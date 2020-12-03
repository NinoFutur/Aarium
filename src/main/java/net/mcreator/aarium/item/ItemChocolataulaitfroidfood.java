
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemChocolataulaitfroidfood extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:chocolataulaitfroidfood")
	public static final Item block = null;

	public ItemChocolataulaitfroidfood(ElementsAariumMod instance) {
		super(instance, 267);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:chocolataulaitfroidfood", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(2, 1f, false);
			setUnlocalizedName("chocolataulaitfroidfood");
			setRegistryName("chocolataulaitfroidfood");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

	}

}
