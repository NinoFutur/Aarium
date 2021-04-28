
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemColdmilkchocolate extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:coldmilkchocolate")
	public static final Item block = null;

	public ItemColdmilkchocolate(ElementsAariumMod instance) {
		super(instance, 282);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:coldmilkchocolate", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(2, 1f, false);
			setUnlocalizedName("coldmilkchocolate");
			setRegistryName("coldmilkchocolate");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.DRINK;
		}

	}

}
