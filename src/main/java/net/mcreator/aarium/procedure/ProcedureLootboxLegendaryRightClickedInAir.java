package net.mcreator.aarium.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.item.ItemLootboxLegendary;
import net.mcreator.aarium.item.ItemLightiumGem;
import net.mcreator.aarium.item.ItemDarkiumingot;
import net.mcreator.aarium.item.ItemAariumnugget;
import net.mcreator.aarium.item.ItemAariumingot;
import net.mcreator.aarium.block.BlockAariumblock;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureLootboxLegendaryRightClickedInAir extends ElementsAariumMod.ModElement {
	public ProcedureLootboxLegendaryRightClickedInAir(ElementsAariumMod instance) {
		super(instance, 413);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LootboxLegendaryRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Chance = 0;
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemLootboxLegendary.block, (int) (1)).getItem(), -1, (int) 1, null);
		for (int index0 = 0; index0 < (int) ((Math.random() * 5)); index0++) {
			Chance = (double) (Math.random() * 1000000);
			if (((Chance) == 0)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumnugget.block, (int) (1));
					_setstack.setCount((int)1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 1) && ((Chance) <= 100000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumnugget.block, (int) (1));
					_setstack.setCount((int)Math.random() * 64);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 100001) && ((Chance) <= 200000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((int)Math.random() * 8);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 200001) && ((Chance) <= 300000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((int)Math.random() * 16);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 300001) && ((Chance) <= 400000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((int)Math.random() * 64);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 400001) && ((Chance) <= 500000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount((int)Math.random() * 128);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 500001) && ((Chance) <= 600000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)Math.random() * 8);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 600001) && ((Chance) <= 700000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)Math.random() * 16);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 700001) && ((Chance) <= 800000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)Math.random() * 32);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 800001) && ((Chance) <= 900000))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)Math.random() * 64);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if ((((Chance) >= 900001) && ((Chance) <= 999999))) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(BlockAariumblock.block, (int) (1));
					_setstack.setCount((int)Math.random() * 128);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
			if (((Chance) == 1000000)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemAariumingot.block, (int) (1));
					_setstack.setCount(100);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemDarkiumingot.block, (int) (1));
					_setstack.setCount(100);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemLightiumGem.block, (int) (1));
					_setstack.setCount(100);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
		}
	}
}
