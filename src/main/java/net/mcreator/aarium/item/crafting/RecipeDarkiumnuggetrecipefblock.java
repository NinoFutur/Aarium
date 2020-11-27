
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemDarkiumingot;
import net.mcreator.aarium.block.BlockDarkiumore;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeDarkiumnuggetrecipefblock extends ElementsAariumMod.ModElement {
	public RecipeDarkiumnuggetrecipefblock(ElementsAariumMod instance) {
		super(instance, 106);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockDarkiumore.block, (int) (1)), new ItemStack(ItemDarkiumingot.block, (int) (1)), 200F);
	}
}
