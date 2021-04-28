
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemChocolatebar extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:chocolatebar")
	public static final Item block = null;

	public ItemChocolatebar(ElementsAariumMod instance) {
		super(instance, 274);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:chocolatebar", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(4, 0.3f, false);
			setUnlocalizedName("chocolatebar");
			setRegistryName("chocolatebar");

			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

	}

}
