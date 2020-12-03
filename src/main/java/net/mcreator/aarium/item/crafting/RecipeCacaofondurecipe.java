
package net.mcreator.aarium.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.aarium.item.ItemCacaofondu;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class RecipeCacaofondurecipe extends ElementsAariumMod.ModElement {
	public RecipeCacaofondurecipe(ElementsAariumMod instance) {
		super(instance, 265);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.DYE, (int) (1), 3), new ItemStack(ItemCacaofondu.block, (int) (1)), 1F);
	}
}
