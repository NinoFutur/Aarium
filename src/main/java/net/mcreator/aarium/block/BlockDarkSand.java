
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.Block;

import net.mcreator.aarium.world.WorldSpawn;
import net.mcreator.aarium.world.WorldSolitudia;
import net.mcreator.aarium.world.WorldSkyaria;
import net.mcreator.aarium.world.WorldSiberia;
import net.mcreator.aarium.world.WorldPateria;
import net.mcreator.aarium.world.WorldForestia;
import net.mcreator.aarium.world.WorldFarmingwood;
import net.mcreator.aarium.world.WorldFarmingstone;
import net.mcreator.aarium.world.WorldFarmingobsidian;
import net.mcreator.aarium.world.WorldFarmingdirt;
import net.mcreator.aarium.world.WorldEvent;
import net.mcreator.aarium.world.WorldAquaria;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;

@ElementsAariumMod.ModElement.Tag
public class BlockDarkSand extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:dark_sand")
	public static final Block block = null;
	public BlockDarkSand(ElementsAariumMod instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("dark_sand"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:dark_sand", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (dimID == WorldSpawn.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldEvent.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingwood.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingstone.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingdirt.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingobsidian.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldAquaria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSiberia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldPateria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldForestia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSolitudia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSkyaria.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("aarium:black_desert")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		for (int i = 0; i < 20; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(255) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 20, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == Blocks.STONE.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.SAND);
			setUnlocalizedName("dark_sand");
			setSoundType(SoundType.SAND);
			setHarvestLevel("shovel", -1);
			setHardness(0.5F);
			setResistance(7F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}
	}
}
