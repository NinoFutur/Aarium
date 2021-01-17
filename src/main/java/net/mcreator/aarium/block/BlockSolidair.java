
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.BlockRenderLayer;
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
public class BlockSolidair extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:solidair")
	public static final Block block = null;
	public BlockSolidair(ElementsAariumMod instance) {
		super(instance, 109);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("solidair"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:solidair", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("solidair");
			setSoundType(SoundType.GROUND);
			setHarvestLevel("pickaxe", 2);
			setHardness(1.5F);
			setResistance(20F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}
}
