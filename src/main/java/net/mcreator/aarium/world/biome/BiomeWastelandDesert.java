
package net.mcreator.aarium.world.biome;

@ElementsAariumMod.ModElement.Tag
public class BiomeWastelandDesert extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:wasteland_desert")
	public static final BiomeGenCustom biome = null;

	public BiomeWastelandDesert(ElementsAariumMod instance) {
		super(instance, 391);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 16));
	}

	static class BiomeGenCustom extends Biome {

		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Wasteland (Desert)").setRainfall(0F).setBaseHeight(1F).setWaterColor(-16764109).setHeightVariation(1F)
					.setTemperature(1.5F));
			setRegistryName("wasteland_desert");
			topBlock = Blocks.SAND.getStateFromMeta(0);
			fillerBlock = Blocks.SANDSTONE.getStateFromMeta(0);
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 1;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;

			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();

		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -10066432;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -10066432;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3355444;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}

	}

}
