
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.Block;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class BlockGreenscreenstairs extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:greenscreenstairs")
	public static final Block block = null;
	public BlockGreenscreenstairs(ElementsAariumMod instance) {
		super(instance, 102);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("greenscreenstairs"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:greenscreenstairs", "inventory"));
	}
	public static class BlockCustom extends BlockStairs {
		public BlockCustom() {
			super(new Block(Material.IRON).getDefaultState());
			setUnlocalizedName("greenscreenstairs");
			setSoundType(SoundType.METAL);
			setHardness(1.9999999999999998F);
			setResistance(10F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);
		}
	}
}
