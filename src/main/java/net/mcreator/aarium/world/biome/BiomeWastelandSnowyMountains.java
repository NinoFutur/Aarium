
package net.mcreator.aarium.world.biome;

@ElementsAariumMod.ModElement.Tag
public class BiomeWastelandSnowyMountains extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:wasteland_snowy_mountains")
	public static final BiomeGenCustom biome = null;

	public BiomeWastelandSnowyMountains(ElementsAariumMod instance) {
		super(instance, 392);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 16));
	}

	static class BiomeGenCustom extends Biome {

		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Wasteland (Snowy Mountains)").setRainfall(1F).setBaseHeight(2F).setWaterColor(-3355393)
					.setHeightVariation(2F).setTemperature(0F));
			setRegistryName("wasteland_snowy_mountains");
			topBlock = Blocks.SNOW.getDefaultState();
			fillerBlock = Blocks.SNOW.getDefaultState();
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
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
			return -1;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -1;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3342337;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}

	}

}
