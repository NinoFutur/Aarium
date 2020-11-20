
package net.mcreator.aarium.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.aarium.item.ItemEnchantedcoalblock;
import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class FuelEnchantedcoal extends ElementsAariumMod.ModElement {
	public FuelEnchantedcoal(ElementsAariumMod instance) {
		super(instance, 173);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemEnchantedcoalblock.block, (int) (1)).getItem())
			return 1000000000;
		return 0;
	}
}
