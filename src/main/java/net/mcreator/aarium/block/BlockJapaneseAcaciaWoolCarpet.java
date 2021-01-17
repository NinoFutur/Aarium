
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aarium.creativetab.TabCollectionJapan;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class BlockJapaneseAcaciaWoolCarpet extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:japanese_acacia_wool_carpet")
	public static final Block block = null;
	public BlockJapaneseAcaciaWoolCarpet(ElementsAariumMod instance) {
		super(instance, 188);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanese_acacia_wool_carpet"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanese_acacia_wool_carpet", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.WOOD);
			setUnlocalizedName("japanese_acacia_wool_carpet");
			setSoundType(SoundType.CLOTH);
			setHarvestLevel("axe", -1);
			setHardness(0.5F);
			setResistance(2F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabCollectionJapan.tab);
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.125D, 1D);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 30;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 30;
		}

		@Override
		public PathNodeType getAiPathNodeType(IBlockState state, IBlockAccess world, BlockPos pos) {
			return PathNodeType.WALKABLE;
		}
	}
}
