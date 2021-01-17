
package net.mcreator.aarium.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.mcreator.aarium.block.BlockDarkSand;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;

@ElementsAariumMod.ModElement.Tag
public class BiomeBlackDesert extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:black_desert")
	public static final BiomeGenCustom biome = null;
	public BiomeBlackDesert(ElementsAariumMod instance) {
		super(instance, 395);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 64));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Black Desert").setRainfall(0.5F).setBaseHeight(0F).setWaterColor(-15987700).setHeightVariation(0F)
					.setTemperature(2F));
			setRegistryName("black_desert");
			topBlock = BlockDarkSand.block.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
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
			return -15987700;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -15987700;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -15987700;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
