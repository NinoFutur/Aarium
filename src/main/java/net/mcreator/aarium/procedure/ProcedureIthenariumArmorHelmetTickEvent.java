package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureIthenariumArmorHelmetTickEvent extends ElementsAariumMod.ModElement {

	public ProcedureIthenariumArmorHelmetTickEvent(ElementsAariumMod instance) {
		super(instance, 295);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure IthenariumArmorHelmetTickEvent!");
			return;
		}

		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 50);

	}

}
