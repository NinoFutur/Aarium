
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemIthenariumingot;
import net.mcreator.aarium.block.BlockIthenariumore;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeIthenariumingotfromblock extends ElementsAariumMod.ModElement {
	public RecipeIthenariumingotfromblock(ElementsAariumMod instance) {
		super(instance, 320);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockIthenariumore.block, (int) (1)), new ItemStack(ItemIthenariumingot.block, (int) (1)), 5F);
	}
}
