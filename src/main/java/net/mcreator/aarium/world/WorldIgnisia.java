
package net.mcreator.aarium.world;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.DimensionManager;

import net.minecraft.world.gen.layer.IntCache;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.World;
import net.minecraft.world.DimensionType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ReportedException;
import net.minecraft.init.Blocks;
import net.minecraft.init.Biomes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.CrashReport;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockFalling;

import net.mcreator.aarium.ElementsAariumMod;

import javax.annotation.Nullable;

import java.util.Random;
import java.util.List;

@ElementsAariumMod.ModElement.Tag
public class WorldIgnisia extends ElementsAariumMod.ModElement {
	public static int DIMID = 27;
	public static final boolean NETHER_TYPE = true;
	public static DimensionType dtype;
	public WorldIgnisia(ElementsAariumMod instance) {
		super(instance, 58);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		if (DimensionManager.isDimensionRegistered(DIMID)) {
			DIMID = DimensionManager.getNextFreeDimId();
			System.err.println("Dimension ID for dimension ignisia is already registered. Falling back to ID: " + DIMID);
		}
		dtype = DimensionType.register("ignisia", "_ignisia", DIMID, WorldProviderMod.class, true);
		DimensionManager.registerDimension(DIMID, dtype);
	}
	public static class WorldProviderMod extends WorldProvider {
		@Override
		public void init() {
			this.biomeProvider = new BiomeProviderCustom(this.world.getSeed());
			this.nether = NETHER_TYPE;
		}

		@Override
		public void calculateInitialWeather() {
		}

		@Override
		public void updateWeather() {
		}

		@Override
		public boolean canDoLightning(net.minecraft.world.chunk.Chunk chunk) {
			return false;
		}

		@Override
		public boolean canDoRainSnowIce(net.minecraft.world.chunk.Chunk chunk) {
			return false;
		}

		@Override
		public DimensionType getDimensionType() {
			return dtype;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Vec3d getFogColor(float par1, float par2) {
			return new Vec3d(0.8, 0, 0);
		}

		@Override
		public IChunkGenerator createChunkGenerator() {
			return new ChunkProviderModded(this.world, this.world.getSeed() - DIMID);
		}

		@Override
		public boolean isSurfaceWorld() {
			return false;
		}

		@Override
		public boolean canRespawnHere() {
			return true;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public boolean doesXZShowFog(int par1, int par2) {
			return true;
		}

		@Override
		public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
			return WorldSleepResult.DENY;
		}

		@Override
		protected void generateLightBrightnessTable() {
			float f = 0.5f;
			for (int i = 0; i <= 15; ++i) {
				float f1 = 1 - (float) i / 15f;
				this.lightBrightnessTable[i] = (1 - f1) / (f1 * 3 + 1) * (1 - f) + f;
			}
		}

		@Override
		public boolean doesWaterVaporize() {
			return false;
		}
	}

	public static class ChunkProviderModded implements IChunkGenerator {
		private static final IBlockState STONE = Blocks.NETHERRACK.getDefaultState();
		private static final IBlockState STONE2 = Blocks.NETHERRACK.getDefaultState();
		private static final IBlockState STONE3 = Blocks.NETHERRACK.getDefaultState();
		private static final IBlockState FLUID = Blocks.FLOWING_LAVA.getDefaultState();
		private static final IBlockState AIR = Blocks.AIR.getDefaultState();
		private static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
		private static final int SEALEVEL = 63;
		private final World world;
		private final Random random;
		private final NoiseGeneratorOctaves lperlinNoise1;
		private final NoiseGeneratorOctaves lperlinNoise2;
		private final NoiseGeneratorOctaves perlinNoise1;
		private final NoiseGeneratorOctaves secondaryStoneNoiseGen;
		private final NoiseGeneratorOctaves depthNoiseGen;
		private final NoiseGeneratorOctaves depthNoise;
		private final MapGenBase genNetherCaves;
		private double[] stoneNoise3 = new double[256];
		private double[] stoneNoise2 = new double[256];
		private double[] depthBuffer = new double[256];
		private double[] buffer;
		private double[] pnr;
		private double[] ar;
		private double[] br;
		private double[] dr;
		double[] unused;
		public ChunkProviderModded(World worldIn, long seed) {
			worldIn.setSeaLevel(SEALEVEL);
			this.world = worldIn;
			this.random = new Random(seed);
			this.lperlinNoise1 = new NoiseGeneratorOctaves(this.random, 16);
			this.lperlinNoise2 = new NoiseGeneratorOctaves(this.random, 16);
			this.perlinNoise1 = new NoiseGeneratorOctaves(this.random, 8);
			this.secondaryStoneNoiseGen = new NoiseGeneratorOctaves(this.random, 4);
			this.depthNoiseGen = new NoiseGeneratorOctaves(this.random, 4);
			this.depthNoise = new NoiseGeneratorOctaves(this.random, 16);
			this.genNetherCaves = new MapGenCavesHell();
		}

		@Override
		public Chunk generateChunk(int x, int z) {
			this.random.setSeed((long) x * 347539041L + (long) z * 535358712L);
			ChunkPrimer chunkprimer = new ChunkPrimer();
			this.prepareHeights(x, z, chunkprimer);
			this.buildSurfaces(x, z, chunkprimer);
			this.genNetherCaves.generate(this.world, x, z, chunkprimer);
			Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
			Biome[] abiome = this.world.getBiomeProvider().getBiomes((Biome[]) null, x * 16, z * 16, 16, 16);
			byte[] abyte = chunk.getBiomeArray();
			for (int i = 0; i < abyte.length; ++i)
				abyte[i] = (byte) Biome.getIdForBiome(abiome[i]);
			chunk.resetRelightChecks();
			return chunk;
		}

		@Override
		public void populate(int x, int z) {
			BlockFalling.fallInstantly = true;
			net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.random, x, z, false);
			int i = x * 16;
			int j = z * 16;
			BlockPos blockpos = new BlockPos(i, 0, j);
			Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
			ChunkPos chunkpos = new ChunkPos(x, z);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS
					.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(this.world, this.random, blockpos));
			biome.decorate(this.world, this.random, new BlockPos(i, 0, j));
			net.minecraftforge.common.MinecraftForge.EVENT_BUS
					.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(this.world, this.random, blockpos));
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
					net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS))
				WorldEntitySpawner.performWorldGenSpawning(this.world, biome, i + 8, j + 8, 16, 16, this.random);
			net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.random, x, z, false);
			BlockFalling.fallInstantly = false;
		}

		@Override
		public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
			return this.world.getBiome(pos).getSpawnableList(creatureType);
		}

		@Override
		public void recreateStructures(Chunk chunkIn, int x, int z) {
		}

		@Override
		public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
			return false;
		}

		@Override
		public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
			return null;
		}

		@Override
		public boolean generateStructures(Chunk chunkIn, int x, int z) {
			return false;
		}

		public void prepareHeights(int p_185936_1_, int p_185936_2_, ChunkPrimer primer) {
			int i = 4;
			int j = this.world.getSeaLevel() / 2 + 1;
			int k = 5;
			int l = 17;
			int i1 = 5;
			this.buffer = this.getHeights(this.buffer, p_185936_1_ * 4, 0, p_185936_2_ * 4, 5, 17, 5);
			for (int j1 = 0; j1 < 4; ++j1) {
				for (int k1 = 0; k1 < 4; ++k1) {
					for (int l1 = 0; l1 < 16; ++l1) {
						double d0 = 0.125D;
						double d1 = this.buffer[((j1 + 0) * 5 + k1 + 0) * 17 + l1 + 0];
						double d2 = this.buffer[((j1 + 0) * 5 + k1 + 1) * 17 + l1 + 0];
						double d3 = this.buffer[((j1 + 1) * 5 + k1 + 0) * 17 + l1 + 0];
						double d4 = this.buffer[((j1 + 1) * 5 + k1 + 1) * 17 + l1 + 0];
						double d5 = (this.buffer[((j1 + 0) * 5 + k1 + 0) * 17 + l1 + 1] - d1) * 0.125D;
						double d6 = (this.buffer[((j1 + 0) * 5 + k1 + 1) * 17 + l1 + 1] - d2) * 0.125D;
						double d7 = (this.buffer[((j1 + 1) * 5 + k1 + 0) * 17 + l1 + 1] - d3) * 0.125D;
						double d8 = (this.buffer[((j1 + 1) * 5 + k1 + 1) * 17 + l1 + 1] - d4) * 0.125D;
						for (int i2 = 0; i2 < 8; ++i2) {
							double d9 = 0.25D;
							double d10 = d1;
							double d11 = d2;
							double d12 = (d3 - d1) * 0.25D;
							double d13 = (d4 - d2) * 0.25D;
							for (int j2 = 0; j2 < 4; ++j2) {
								double d14 = 0.25D;
								double d15 = d10;
								double d16 = (d11 - d10) * 0.25D;
								for (int k2 = 0; k2 < 4; ++k2) {
									IBlockState iblockstate = null;
									if (l1 * 8 + i2 < j) {
										iblockstate = FLUID;
									}
									if (d15 > 0.0D) {
										iblockstate = STONE;
									}
									int l2 = j2 + j1 * 4;
									int i3 = i2 + l1 * 8;
									int j3 = k2 + k1 * 4;
									primer.setBlockState(l2, i3, j3, iblockstate);
									d15 += d16;
								}
								d10 += d12;
								d11 += d13;
							}
							d1 += d5;
							d2 += d6;
							d3 += d7;
							d4 += d8;
						}
					}
				}
			}
		}

		private double[] getHeights(double[] p_185938_1_, int p_185938_2_, int p_185938_3_, int p_185938_4_, int p_185938_5_, int p_185938_6_,
				int p_185938_7_) {
			if (p_185938_1_ == null) {
				p_185938_1_ = new double[p_185938_5_ * p_185938_6_ * p_185938_7_];
			}
			net.minecraftforge.event.terraingen.ChunkGeneratorEvent.InitNoiseField event = new net.minecraftforge.event.terraingen.ChunkGeneratorEvent.InitNoiseField(
					this, p_185938_1_, p_185938_2_, p_185938_3_, p_185938_4_, p_185938_5_, p_185938_6_, p_185938_7_);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
			if (event.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.DENY)
				return event.getNoisefield();
			double d0 = 684.412D;
			double d1 = 2053.236D;
			this.unused = new NoiseGeneratorOctaves(this.random, 10).generateNoiseOctaves(this.unused, p_185938_2_, p_185938_3_, p_185938_4_,
					p_185938_5_, 1, p_185938_7_, 1.0D, 0.0D, 1.0D);
			this.dr = this.depthNoise.generateNoiseOctaves(this.dr, p_185938_2_, p_185938_3_, p_185938_4_, p_185938_5_, 1, p_185938_7_, 100.0D, 0.0D,
					100.0D);
			this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, p_185938_2_, p_185938_3_, p_185938_4_, p_185938_5_, p_185938_6_, p_185938_7_,
					8.555150000000001D, 34.2206D, 8.555150000000001D);
			this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, p_185938_2_, p_185938_3_, p_185938_4_, p_185938_5_, p_185938_6_, p_185938_7_,
					684.412D, 2053.236D, 684.412D);
			this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, p_185938_2_, p_185938_3_, p_185938_4_, p_185938_5_, p_185938_6_, p_185938_7_,
					684.412D, 2053.236D, 684.412D);
			int i = 0;
			double[] adouble = new double[p_185938_6_];
			for (int j = 0; j < p_185938_6_; ++j) {
				adouble[j] = Math.cos((double) j * Math.PI * 6.0D / (double) p_185938_6_) * 2.0D;
				double d2 = (double) j;
				if (j > p_185938_6_ / 2) {
					d2 = (double) (p_185938_6_ - 1 - j);
				}
				if (d2 < 4.0D) {
					d2 = 4.0D - d2;
					adouble[j] -= d2 * d2 * d2 * 10.0D;
				}
			}
			for (int l = 0; l < p_185938_5_; ++l) {
				for (int i1 = 0; i1 < p_185938_7_; ++i1) {
					double d3 = 0.0D;
					for (int k = 0; k < p_185938_6_; ++k) {
						double d4 = adouble[k];
						double d5 = this.ar[i] / 512.0D;
						double d6 = this.br[i] / 512.0D;
						double d7 = (this.pnr[i] / 10.0D + 1.0D) / 2.0D;
						double d8;
						if (d7 < 0.0D) {
							d8 = d5;
						} else if (d7 > 1.0D) {
							d8 = d6;
						} else {
							d8 = d5 + (d6 - d5) * d7;
						}
						d8 = d8 - d4;
						if (k > p_185938_6_ - 4) {
							double d9 = (double) ((float) (k - (p_185938_6_ - 4)) / 3.0F);
							d8 = d8 * (1.0D - d9) + -10.0D * d9;
						}
						if ((double) k < 0.0D) {
							double d10 = (0.0D - (double) k) / 4.0D;
							d10 = MathHelper.clamp(d10, 0.0D, 1.0D);
							d8 = d8 * (1.0D - d10) + -10.0D * d10;
						}
						p_185938_1_[i] = d8;
						++i;
					}
				}
			}
			return p_185938_1_;
		}

		public void buildSurfaces(int p_185937_1_, int p_185937_2_, ChunkPrimer primer) {
			if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, p_185937_1_, p_185937_2_, primer, this.world))
				return;
			int i = this.world.getSeaLevel() + 1;
			double d0 = 0.03125D;
			this.stoneNoise2 = this.secondaryStoneNoiseGen.generateNoiseOctaves(this.stoneNoise2, p_185937_1_ * 16, p_185937_2_ * 16, 0, 16, 16, 1,
					0.03125D, 0.03125D, 1.0D);
			this.stoneNoise3 = this.secondaryStoneNoiseGen.generateNoiseOctaves(this.stoneNoise3, p_185937_1_ * 16, 109, p_185937_2_ * 16, 16, 1, 16,
					0.03125D, 1.0D, 0.03125D);
			this.depthBuffer = this.depthNoiseGen.generateNoiseOctaves(this.depthBuffer, p_185937_1_ * 16, p_185937_2_ * 16, 0, 16, 16, 1, 0.0625D,
					0.0625D, 0.0625D);
			for (int j = 0; j < 16; ++j) {
				for (int k = 0; k < 16; ++k) {
					boolean flag = this.stoneNoise2[j + k * 16] + this.random.nextDouble() * 0.2D > 0.0D;
					boolean flag1 = this.stoneNoise3[j + k * 16] + this.random.nextDouble() * 0.2D > 0.0D;
					int l = (int) (this.depthBuffer[j + k * 16] / 3.0D + 3.0D + this.random.nextDouble() * 0.25D);
					int i1 = -1;
					IBlockState iblockstate = STONE;
					IBlockState iblockstate1 = STONE;
					for (int j1 = 127; j1 >= 0; --j1) {
						if (j1 < 127 - this.random.nextInt(5) && j1 > this.random.nextInt(5)) {
							IBlockState iblockstate2 = primer.getBlockState(k, j1, j);
							if (iblockstate2.getBlock() != null && iblockstate2.getMaterial() != Material.AIR) {
								if (iblockstate2.getBlock() == STONE.getBlock()) {
									if (i1 == -1) {
										if (l <= 0) {
											iblockstate = AIR;
											iblockstate1 = STONE;
										} else if (j1 >= i - 4 && j1 <= i + 1) {
											iblockstate = STONE;
											iblockstate1 = STONE;
											if (flag1) {
												iblockstate = STONE3;
												iblockstate1 = STONE;
											}
											if (flag) {
												iblockstate = STONE2;
												iblockstate1 = STONE2;
											}
										}
										if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
											iblockstate = FLUID;
										}
										i1 = l;
										if (j1 >= i - 1) {
											primer.setBlockState(k, j1, j, iblockstate);
										} else {
											primer.setBlockState(k, j1, j, iblockstate1);
										}
									} else if (i1 > 0) {
										--i1;
										primer.setBlockState(k, j1, j, iblockstate1);
									}
								}
							} else {
								i1 = -1;
							}
						} else {
							primer.setBlockState(k, j1, j, BEDROCK);
						}
					}
				}
			}
		}
	}

	public static class GenLayerBiomesCustom extends GenLayer {
		private Biome[] allowedBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("hell")),
				Biome.REGISTRY.getObject(new ResourceLocation("river")),};
		public GenLayerBiomesCustom(long seed) {
			super(seed);
		}

		@Override
		public int[] getInts(int x, int z, int width, int depth) {
			int[] dest = IntCache.getIntCache(width * depth);
			for (int dz = 0; dz < depth; dz++) {
				for (int dx = 0; dx < width; dx++) {
					this.initChunkSeed(dx + x, dz + z);
					dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
				}
			}
			return dest;
		}
	}

	public static class BiomeProviderCustom extends BiomeProvider {
		private GenLayer genBiomes;
		private GenLayer biomeIndexLayer;
		private BiomeCache biomeCache;
		public BiomeProviderCustom() {
			this.biomeCache = new BiomeCache(this);
		}

		public BiomeProviderCustom(long seed) {
			this.biomeCache = new BiomeCache(this);
			GenLayer[] agenlayer = makeTheWorld(seed);
			this.genBiomes = agenlayer[0];
			this.biomeIndexLayer = agenlayer[1];
		}

		private GenLayer[] makeTheWorld(long seed) {
			GenLayer biomes = new GenLayerBiomesCustom(1);
			biomes = new GenLayerZoom(1000, biomes);
			biomes = new GenLayerZoom(1001, biomes);
			biomes = new GenLayerZoom(1002, biomes);
			biomes = new GenLayerZoom(1003, biomes);
			biomes = new GenLayerZoom(1004, biomes);
			biomes = new GenLayerZoom(1005, biomes);
			GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10, biomes);
			biomes.initWorldGenSeed(seed);
			genlayervoronoizoom.initWorldGenSeed(seed);
			return new GenLayer[]{biomes, genlayervoronoizoom};
		}

		public BiomeProviderCustom(World world) {
			this(world.getSeed());
		}

		@Override
		public void cleanupCache() {
			this.biomeCache.cleanupCache();
		}

		@Override
		public Biome getBiome(BlockPos pos) {
			return this.getBiome(pos, null);
		}

		@Override
		public Biome getBiome(BlockPos pos, Biome defaultBiome) {
			return this.biomeCache.getBiome(pos.getX(), pos.getZ(), defaultBiome);
		}

		@Override
		public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
			return this.getBiomes(oldBiomeList, x, z, width, depth, true);
		}

		@Override /**
					 * Returns an array of biomes for the location input.
					 */
		public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
			IntCache.resetIntCache();
			if (biomes == null || biomes.length < width * height) {
				biomes = new Biome[width * height];
			}
			int[] aint = this.genBiomes.getInts(x, z, width, height);
			try {
				for (int i = 0; i < width * height; ++i) {
					biomes[i] = Biome.getBiome(aint[i], Biomes.DEFAULT);
				}
				return biomes;
			} catch (Throwable throwable) {
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
				CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
				crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
				crashreportcategory.addCrashSection("x", Integer.valueOf(x));
				crashreportcategory.addCrashSection("z", Integer.valueOf(z));
				crashreportcategory.addCrashSection("w", Integer.valueOf(width));
				crashreportcategory.addCrashSection("h", Integer.valueOf(height));
				throw new ReportedException(crashreport);
			}
		}

		@Override /**
					 * Gets a list of biomes for the specified blocks.
					 */
		public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag) {
			IntCache.resetIntCache();
			if (listToReuse == null || listToReuse.length < width * length) {
				listToReuse = new Biome[width * length];
			}
			if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0) {
				Biome[] abiome = this.biomeCache.getCachedBiomes(x, z);
				System.arraycopy(abiome, 0, listToReuse, 0, width * length);
				return listToReuse;
			} else {
				int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);
				for (int i = 0; i < width * length; ++i) {
					listToReuse[i] = Biome.getBiome(aint[i], Biomes.DEFAULT);
				}
				return listToReuse;
			}
		}

		@Override /**
					 * checks given Chunk's Biomes against List of allowed ones
					 */
		public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
			IntCache.resetIntCache();
			int i = x - radius >> 2;
			int j = z - radius >> 2;
			int k = x + radius >> 2;
			int l = z + radius >> 2;
			int i1 = k - i + 1;
			int j1 = l - j + 1;
			int[] aint = this.genBiomes.getInts(i, j, i1, j1);
			try {
				for (int k1 = 0; k1 < i1 * j1; ++k1) {
					Biome biome = Biome.getBiome(aint[k1]);
					if (!allowed.contains(biome)) {
						return false;
					}
				}
				return true;
			} catch (Throwable throwable) {
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
				CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
				crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
				crashreportcategory.addCrashSection("x", Integer.valueOf(x));
				crashreportcategory.addCrashSection("z", Integer.valueOf(z));
				crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
				crashreportcategory.addCrashSection("allowed", allowed);
				throw new ReportedException(crashreport);
			}
		}

		@Override
		@Nullable
		public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
			IntCache.resetIntCache();
			int i = x - range >> 2;
			int j = z - range >> 2;
			int k = x + range >> 2;
			int l = z + range >> 2;
			int i1 = k - i + 1;
			int j1 = l - j + 1;
			int[] aint = this.genBiomes.getInts(i, j, i1, j1);
			BlockPos blockpos = null;
			int k1 = 0;
			for (int l1 = 0; l1 < i1 * j1; ++l1) {
				int i2 = i + l1 % i1 << 2;
				int j2 = j + l1 / i1 << 2;
				Biome biome = Biome.getBiome(aint[l1]);
				if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0)) {
					blockpos = new BlockPos(i2, 0, j2);
					++k1;
				}
			}
			return blockpos;
		}
	}
}
