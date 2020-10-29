package net.mcreator.aarium.procedures;

@AariumModElements.ModElement.Tag
public class PlayerfrezerLivingEntityIsHitWithItemProcedure extends AariumModElements.ModElement {

	public PlayerfrezerLivingEntityIsHitWithItemProcedure(AariumModElements instance) {
		super(instance, 155);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}

		Entity sourceentity = (Entity) dependencies.get("sourceentity");

		if (((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(PlayerfrezerItem.block, (int) (1)))
				: false)) {
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(PlayerfrezerItem.block, (int) (1));
				((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
		}

	}

}
