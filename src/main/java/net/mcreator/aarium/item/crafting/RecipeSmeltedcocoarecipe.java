
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.aarium.item.ItemSmeltedcocoa;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeSmeltedcocoarecipe extends ElementsAariumMod.ModElement {
	public RecipeSmeltedcocoarecipe(ElementsAariumMod instance) {
		super(instance, 326);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.DYE, (int) (1), 3), new ItemStack(ItemSmeltedcocoa.block, (int) (1)), 1F);
	}
}
