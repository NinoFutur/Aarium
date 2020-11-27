
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemAariumingot;
import net.mcreator.aarium.block.BlockAariumore;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeAariumoresmelt extends ElementsAariumMod.ModElement {
	public RecipeAariumoresmelt(ElementsAariumMod instance) {
		super(instance, 173);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAariumore.block, (int) (1)), new ItemStack(ItemAariumingot.block, (int) (1)), 50F);
	}
}
