
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemNearentitiesfinder extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:nearentitiesfinder")
	public static final Item block = null;

	public ItemNearentitiesfinder(ElementsAariumMod instance) {
		super(instance, 167);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:nearentitiesfinder", "inventory"));
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			setMaxDamage(75);
			maxStackSize = 1;
			setUnlocalizedName("nearentitiesfinder");
			setRegistryName("nearentitiesfinder");
			setCreativeTab(CreativeTabs.TOOLS);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 10;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				ProcedureNearentitiesfinderRightClickedInAir.executeProcedure($_dependencies);
			}
			return ar;
		}

	}

}
