
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganaa extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganaa")
	public static final Block block = null;
	public BlockJapanesetexthiraganaa(ElementsAariumMod instance) {
		super(instance, 301);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganaa"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganaa", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.CLOTH);
			setUnlocalizedName("japanesetexthiraganaa");
			setSoundType(SoundType.CLOTH);
			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);
		}
	}
}
