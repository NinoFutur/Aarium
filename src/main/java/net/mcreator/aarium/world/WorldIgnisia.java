
package net.mcreator.aarium.world;

@ElementsAariumMod.ModElement.Tag
public class WorldIgnisia extends ElementsAariumMod.ModElement {

	public static int DIMID = 53;
	public static final boolean NETHER_TYPE = true;

	public static DimensionType dtype;

	public WorldIgnisia(ElementsAariumMod instance) {
		super(instance, 152);
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

		/* failed to load code for net.minecraft.world.gen.ChunkGeneratorHell */

		/* failed to load code for net.minecraft.world.gen.ChunkGeneratorHell */

		/* failed to load code for net.minecraft.world.gen.ChunkGeneratorHell */

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
