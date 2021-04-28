
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemSmeltedcocoa extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:smeltedcocoa")
	public static final Item block = null;

	public ItemSmeltedcocoa(ElementsAariumMod instance) {
		super(instance, 273);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:smeltedcocoa", "inventory"));
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 64;
			setUnlocalizedName("smeltedcocoa");
			setRegistryName("smeltedcocoa");
			setCreativeTab(CreativeTabs.FOOD);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}

	}

}
