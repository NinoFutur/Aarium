
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemChocolatchaud extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:chocolatchaud")
	public static final Item block = null;

	public ItemChocolatchaud(ElementsAariumMod instance) {
		super(instance, 266);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:chocolatchaud", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(3, 1f, false);
			setUnlocalizedName("chocolatchaud");
			setRegistryName("chocolatchaud");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(1);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

	}

}
