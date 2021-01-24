package net.mcreator.aarium.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureIthenariumarmorBodyTickEvent extends ElementsAariumMod.ModElement {
	public ProcedureIthenariumarmorBodyTickEvent(ElementsAariumMod instance) {
		super(instance, 286);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure IthenariumarmorBodyTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		for (int index0 = 0; index0 < (int) (1); index0++) {
			((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 250);
		}
	}
}
