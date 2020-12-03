
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemChocolatchaud;
import net.mcreator.aarium.item.ItemChocolataulaitfroidfood;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeChocolatchaudrecipe extends ElementsAariumMod.ModElement {
	public RecipeChocolatchaudrecipe(ElementsAariumMod instance) {
		super(instance, 272);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemChocolataulaitfroidfood.block, (int) (1)), new ItemStack(ItemChocolatchaud.block, (int) (1)), 1F);
	}
}
