
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aarium.world.WorldSolitudia;
import net.mcreator.aarium.world.WorldSkyaria;
import net.mcreator.aarium.world.WorldSiberia;
import net.mcreator.aarium.world.WorldPateria;
import net.mcreator.aarium.world.WorldForestia;
import net.mcreator.aarium.world.WorldFarmingstone;
import net.mcreator.aarium.world.WorldAquaria;
import net.mcreator.aarium.procedure.ProcedureIthenariumoreBlockDestroyedByPlayer;
import net.mcreator.aarium.item.ItemIthenariumdust;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class BlockIthenariumore extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:ithenariumore")
	public static final Block block = null;
	public BlockIthenariumore(ElementsAariumMod instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ithenariumore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:ithenariumore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (dimID == WorldFarmingstone.DIMID)
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
		for (int i = 0; i < 6; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(16) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 5, new com.google.common.base.Predicate<IBlockState>() {
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
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("ithenariumore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 3);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0.33F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemIthenariumdust.block, (int) (1)));
		}

		@Override
		public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureIthenariumoreBlockDestroyedByPlayer.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
