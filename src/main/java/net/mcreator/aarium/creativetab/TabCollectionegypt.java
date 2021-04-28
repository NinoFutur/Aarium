
package net.mcreator.aarium.creativetab;

@ElementsAariumMod.ModElement.Tag
public class TabCollectionegypt extends ElementsAariumMod.ModElement {

	public TabCollectionegypt(ElementsAariumMod instance) {
		super(instance, 222);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabcollectionegypt") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemEgyptianblock0.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static CreativeTabs tab;

}
