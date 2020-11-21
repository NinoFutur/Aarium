package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureSuperenchanteurbuttonclick extends ElementsAariumMod.ModElement {

	public ProcedureSuperenchanteurbuttonclick(ElementsAariumMod instance) {
		super(instance, 178);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Superenchanteurbuttonclick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(Items.ENCHANTED_BOOK, (int) (1)).getItem())) {
			if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, (ItemStack.EMPTY))) == 4)) {
				if (((new Object() {
					public ItemStack getItemStack(int sltid) {
						if (entity instanceof EntityPlayerMP) {
							Container _current = ((EntityPlayerMP) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem() == new ItemStack(Items.ENCHANTED_BOOK, (int) (1)).getItem())) {
					if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, (ItemStack.EMPTY))) == 4)) {
						if (entity instanceof EntityPlayerMP) {
							Container _current = ((EntityPlayerMP) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK, (int) (1));
									_setstack.setCount(1);
									((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					}
				}
			}
		}

	}

}
