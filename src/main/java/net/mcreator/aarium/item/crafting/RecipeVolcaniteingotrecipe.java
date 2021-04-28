
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemVolcaniteingot;
import net.mcreator.aarium.block.BlockVolcaniteore;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeVolcaniteingotrecipe extends ElementsAariumMod.ModElement {
	public RecipeVolcaniteingotrecipe(ElementsAariumMod instance) {
		super(instance, 160);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockVolcaniteore.block, (int) (1)), new ItemStack(ItemVolcaniteingot.block, (int) (1)), 80F);
	}
}
