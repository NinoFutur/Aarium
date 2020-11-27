
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemLightiumGem;
import net.mcreator.aarium.block.BlockLightiumOre;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeLightiumOreSmelting extends ElementsAariumMod.ModElement {
	public RecipeLightiumOreSmelting(ElementsAariumMod instance) {
		super(instance, 126);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockLightiumOre.block, (int) (1)), new ItemStack(ItemLightiumGem.block, (int) (1)), 150F);
	}
}
