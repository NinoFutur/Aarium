
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemStrawberry extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:strawberry")
	public static final Item block = null;

	public ItemStrawberry(ElementsAariumMod instance) {
		super(instance, 164);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:strawberry", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(1, 0.5f, false);
			setUnlocalizedName("strawberry");
			setRegistryName("strawberry");
			setAlwaysEdible();
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 8;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

	}

}
