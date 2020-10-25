
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class LightiumSwordItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:lightium_sword")
	public static final Item block = null;
	public LightiumSwordItem(AariumModElements instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 50000;
			}

			public float getEfficiency() {
				return 50000f;
			}

			public float getAttackDamage() {
				return 49996f;
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
		}, 3, 96f, new Item.Properties().group(null)) {
		}.setRegistryName("lightium_sword"));
	}
}
