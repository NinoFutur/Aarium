
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class LightiumShovelItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:lightium_shovel")
	public static final Item block = null;
	public LightiumShovelItem(AariumModElements instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 50000;
			}

			public float getEfficiency() {
				return 50000f;
			}

			public float getAttackDamage() {
				return -1.7f;
			}

			public int getHarvestLevel() {
				return 50000;
			}

			public int getEnchantability() {
				return 50000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.9f, new Item.Properties().group(null)) {
		}.setRegistryName("lightium_shovel"));
	}
}
