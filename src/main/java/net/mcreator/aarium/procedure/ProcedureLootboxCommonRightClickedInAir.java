package net.mcreator.aarium.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.item.ItemLootboxCommon;
import net.mcreator.aarium.item.ItemAariumnugget;
import net.mcreator.aarium.item.ItemAariumingot;
import net.mcreator.aarium.block.BlockAariumblock;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

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
		Chance = (double) (Math.random() * 10);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemLootboxCommon.block, (int) (1)).getItem(), -1, (int) 1, null);
		if (((Chance) <= 20)) {
			LootNumber = (double) (Math.random() * 3);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemAariumnugget.block, (int) (1));
				_setstack.setCount((int)LootNumber);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else {
			if (((Chance) >= 80)) {
				LootNumber = (double) (Math.random() * 2);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)LootNumber);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else {
				LootNumber = (double) (Math.random() * 5);
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((int)LootNumber);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
		}
	}
}
