
package net.mcreator.aarium.world;

@ElementsAariumMod.ModElement.Tag
public class WorldEvent extends ElementsAariumMod.ModElement {

	public static int DIMID = 51;
	public static final boolean NETHER_TYPE = false;

	public static DimensionType dtype;

	public WorldEvent(ElementsAariumMod instance) {
		super(instance, 25);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		if (DimensionManager.isDimensionRegistered(DIMID)) {
			DIMID = DimensionManager.getNextFreeDimId();
			System.err.println("Dimension ID for dimension event is already registered. Falling back to ID: " + DIMID);
		}
		dtype = DimensionType.register("event", "_event", DIMID, WorldProviderMod.class, true);
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
			return new Vec3d(0.752941176471, 0.847058823529, 1);
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
			return false;
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
		private static final IBlockState STONE = Blocks.AIR.getDefaultState();
		private static final IBlockState STONE2 = Blocks.AIR.getDefaultState();
		private static final IBlockState FLUID = Blocks.FLOWING_WATER.getDefaultState();
		private static final IBlockState AIR = Blocks.AIR.getDefaultState();
		private static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();

		private static final int SEALEVEL = 63;

		private final Random random;
		private final NoiseGeneratorOctaves perlin1;
		private final NoiseGeneratorOctaves perlin2;
		private final NoiseGeneratorOctaves perlin;
		private final NoiseGeneratorPerlin height;
		private final NoiseGeneratorOctaves depth;
		private final World world;
		private final WorldType terrainType;
		private final MapGenBase caveGenerator;
		private final MapGenBase ravineGenerator;

		private Biome[] biomesForGeneration;
		private double[] heightMap;
		private double[] depthbuff = new double[256];
		private double[] noiseRegMain;
		private double[] limitRegMin;
		private double[] limitRegMax;
		private double[] depthReg;
		private float[] biomeWeights;

		public ChunkProviderModded(World worldIn, long seed) {
			worldIn.setSeaLevel(SEALEVEL);

			caveGenerator = new MapGenCaves() {
				@Override
				protected boolean canReplaceBlock(IBlockState a, IBlockState b) {
					if (a.getBlock() == STONE.getBlock())
						return true;
					return super.canReplaceBlock(a, b);
				}
			};

			ravineGenerator = new MapGenRavine() {
				@Override
				protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop) {
					net.minecraft.world.biome.Biome biome = world.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
					IBlockState state = data.getBlockState(x, y, z);
					if (state.getBlock() == STONE.getBlock() || state.getBlock() == biome.topBlock.getBlock()
							|| state.getBlock() == biome.fillerBlock.getBlock()) {
						if (y - 1 < 10) {
							data.setBlockState(x, y, z, FLOWING_LAVA);
						} else {
							data.setBlockState(x, y, z, AIR);

							if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == biome.fillerBlock.getBlock()) {
								data.setBlockState(x, y - 1, z, biome.topBlock.getBlock().getDefaultState());
							}
						}
					}
				}
			};

			this.world = worldIn;
			this.terrainType = worldIn.getWorldInfo().getTerrainType();
			this.random = new Random(seed);
			this.perlin1 = new NoiseGeneratorOctaves(this.random, 16);
			this.perlin2 = new NoiseGeneratorOctaves(this.random, 16);
			this.perlin = new NoiseGeneratorOctaves(this.random, 8);
			this.height = new NoiseGeneratorPerlin(this.random, 4);
			this.depth = new NoiseGeneratorOctaves(this.random, 16);
			this.heightMap = new double[825];
			this.biomeWeights = new float[25];

			for (int i = -2; i <= 2; i++)
				for (int j = -2; j <= 2; j++)
					this.biomeWeights[i + 2 + (j + 2) * 5] = 10 / MathHelper.sqrt((float) (i * i + j * j) + 0.2f);
		}

		@Override
		public Chunk generateChunk(int x, int z) {
			this.random.setSeed((long) x * 535358712L + (long) z * 347539041L);
			ChunkPrimer chunkprimer = new ChunkPrimer();
			this.setBlocksInChunk(x, z, chunkprimer);

			this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 16, z * 16, 16, 16);
			this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

			this.caveGenerator.generate(this.world, x, z, chunkprimer);
			this.ravineGenerator.generate(this.world, x, z, chunkprimer);

			Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
			byte[] abyte = chunk.getBiomeArray();

			for (int i = 0; i < abyte.length; ++i)
				abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);

			chunk.generateSkylightMap();
			return chunk;
		}

		@Override
		public void populate(int x, int z) {
			BlockFalling.fallInstantly = true;

			int i = x * 16;
			int j = z * 16;

			BlockPos blockpos = new BlockPos(i, 0, j);
			Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
			this.random.setSeed(this.world.getSeed());
			long k = this.random.nextLong() / 2 * 2 + 1;
			long l = this.random.nextLong() / 2 * 2 + 1;
			this.random.setSeed((long) x * k + (long) z * l ^ this.world.getSeed());

			net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.random, x, z, false);

			if (this.random.nextInt(4) == 0)
				if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.random, x, z, false,
						net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
					int i1 = this.random.nextInt(16) + 8;
					int j1 = this.random.nextInt(256);
					int k1 = this.random.nextInt(16) + 8;
					(new WorldGenLakes(FLUID.getBlock())).generate(this.world, this.random, blockpos.add(i1, j1, k1));
				}

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

		/* failed to load code for net.minecraft.world.gen.ChunkGeneratorOverworld */

		/* failed to load code for net.minecraft.world.gen.ChunkGeneratorOverworld */

		private void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
			this.depthbuff = this.height.getRegion(this.depthbuff, (double) (x * 16), (double) (z * 16), 16, 16, 0.0625, 0.0625, 1);
			for (int i = 0; i < 16; i++)
				for (int j = 0; j < 16; j++)
					generateBiomeTerrain(this.world, this.random, primer, x * 16 + i, z * 16 + j, this.depthbuff[j + i * 16], biomesIn[j + i * 16]);
		}

		/* failed to load code for net.minecraft.world.biome.Biome */

	}

	public static class GenLayerBiomesCustom extends GenLayer {

		private Biome[] allowedBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("void")),};

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
		return new GenLayer[] { biomes, genlayervoronoizoom };
	}

	public BiomeProviderCustom(World world) {
		this(world.getSeed());
	}

	@Override public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}

	@Override public Biome getBiome(BlockPos pos) {
		return this.getBiome(pos, null);
	}

	@Override public Biome getBiome(BlockPos pos, Biome defaultBiome) {
		return this.biomeCache.getBiome(pos.getX(), pos.getZ(), defaultBiome);
	}

	@Override public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
		return this.getBiomes(oldBiomeList, x, z, width, depth, true);
	}

	@Override /* failed to load code for net.minecraft.world.biome.BiomeProvider */

	@Override /* failed to load code for net.minecraft.world.biome.BiomeProvider */

	@Override /* failed to load code for net.minecraft.world.biome.BiomeProvider */

	@Override /* failed to load code for net.minecraft.world.biome.BiomeProvider */

}
}
