
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
public class BlockEgyptianBlock8 extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:egyptian_block_8")
	public static final Block block = null;
	public BlockEgyptianBlock8(ElementsAariumMod instance) {
		super(instance, 203);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("egyptian_block_8"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:egyptian_block_8", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("egyptian_block_8");
			setSoundType(SoundType.SAND);
			setHarvestLevel("pickaxe", 2);
			setHardness(2F);
			setResistance(20F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);
		}
	}
}
