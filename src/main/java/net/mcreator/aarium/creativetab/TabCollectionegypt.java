
package net.mcreator.aarium.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.aarium.block.BlockEgyptianblock0;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class TabCollectionegypt extends ElementsAariumMod.ModElement {
	public TabCollectionegypt(ElementsAariumMod instance) {
		super(instance, 300);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabcollectionegypt") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockEgyptianblock0.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
