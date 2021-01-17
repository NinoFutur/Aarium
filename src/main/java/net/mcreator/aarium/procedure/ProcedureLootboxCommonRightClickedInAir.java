package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureLootboxCommonRightClickedInAir extends ElementsAariumMod.ModElement {

	public ProcedureLootboxCommonRightClickedInAir(ElementsAariumMod instance) {
		super(instance, 410);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LootboxCommonRightClickedInAir!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		double Chance = 0;
		double LootNumber = 0;
		ItemStack Win = ItemStack.EMPTY;
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemLootboxCommon.block, (int) (1)).getItem(), -1, (int) 1, null);
		Chance = (double) (Math.random() * 10);
		if (((Chance) < 2)) {
			LootNumber = (double) (Math.random() * 12);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemAariumnugget.block, (int) (1));
				_setstack.setCount((LootNumber));
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			Win = new ItemStack(ItemAariumnugget.block, (int) (1));
		} else {
			if (((Chance) > 8)) {
				LootNumber = (double) (Math.random() * 2);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((LootNumber));
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
				Win = new ItemStack(BlockAariumblock.block, (int) (1));
			} else {
				LootNumber = (double) (Math.random() * 5);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((LootNumber));
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
				Win = new ItemStack(ItemAariumingot.block, (int) (1));
			}
		}
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(
					new TextComponentString((("Vou avez eu ") + "" + ((LootNumber)) + "" + ( /*@ItemStack*/(Win)) + "" + ("!"))), (true));
		}

	}

}
