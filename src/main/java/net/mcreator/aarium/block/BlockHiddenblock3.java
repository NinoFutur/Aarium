
package net.mcreator.aarium.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.List;

@ElementsAariumMod.ModElement.Tag
public class BlockHiddenblock3 extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:hiddenblock_3")
	public static final Block block = null;
	public BlockHiddenblock3(ElementsAariumMod instance) {
		super(instance, 236);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("hiddenblock_3"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:hiddenblock_3", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.IRON);
			setUnlocalizedName("hiddenblock_3");
			setSoundType(SoundType.METAL);
			setHardness(1F);
			setResistance(10000F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("Cheh");
		}
	}
}
