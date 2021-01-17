
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
import net.minecraft.block.Block;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class BlockModernblock100 extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:modernblock_100")
	public static final Block block = null;
	public BlockModernblock100(ElementsAariumMod instance) {
		super(instance, 113);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("modernblock_100"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:modernblock_100", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.GRASS);
			setUnlocalizedName("modernblock_100");
			setSoundType(SoundType.GROUND);
			setHardness(1.4000000000000001F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);
		}
	}
}
