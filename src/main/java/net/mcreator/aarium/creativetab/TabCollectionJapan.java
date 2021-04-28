
package net.mcreator.aarium.creativetab;

@ElementsAariumMod.ModElement.Tag
public class TabCollectionJapan extends ElementsAariumMod.ModElement {

	public TabCollectionJapan(ElementsAariumMod instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabcollection_japan") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockJapaneseBlock1.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static CreativeTabs tab;

}
