
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class BlockFakeGrass extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:fake_grass")
	public static final Block block = null;
	public BlockFakeGrass(ElementsAariumMod instance) {
		super(instance, 182);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("fake_grass"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:fake_grass", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.GRASS);
			setUnlocalizedName("fake_grass");
			setSoundType(SoundType.GROUND);
			setHarvestLevel("pickaxe", 0);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.REDSTONE);
		}

		@Override
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}
}
