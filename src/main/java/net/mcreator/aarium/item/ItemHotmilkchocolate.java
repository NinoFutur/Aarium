
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemHotmilkchocolate extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:hotmilkchocolate")
	public static final Item block = null;

	public ItemHotmilkchocolate(ElementsAariumMod instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:hotmilkchocolate", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(3, 1f, false);
			setUnlocalizedName("hotmilkchocolate");
			setRegistryName("hotmilkchocolate");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

	}

}
