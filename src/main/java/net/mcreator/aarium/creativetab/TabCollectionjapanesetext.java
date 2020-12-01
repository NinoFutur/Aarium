
package net.mcreator.aarium.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.aarium.block.BlockJapanesetexthiraganaa;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class TabCollectionjapanesetext extends ElementsAariumMod.ModElement {
	public TabCollectionjapanesetext(ElementsAariumMod instance) {
		super(instance, 223);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabcollectionjapanesetext") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockJapanesetexthiraganaa.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
