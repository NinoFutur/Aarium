
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemMugofmilk extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:mugofmilk")
	public static final Item block = null;

	public ItemMugofmilk(ElementsAariumMod instance) {
		super(instance, 279);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:mugofmilk", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(2, 0.3f, false);
			setUnlocalizedName("mugofmilk");
			setRegistryName("mugofmilk");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

	}

}
