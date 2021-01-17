
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemHotmilkchocolate;
import net.mcreator.aarium.item.ItemColdmilkchocolate;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeHotmilkchocolaterecipe extends ElementsAariumMod.ModElement {
	public RecipeHotmilkchocolaterecipe(ElementsAariumMod instance) {
		super(instance, 329);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemColdmilkchocolate.block, (int) (1)), new ItemStack(ItemHotmilkchocolate.block, (int) (1)), 1F);
	}
}
