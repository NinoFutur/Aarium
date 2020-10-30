
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class OPSwordItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:op_sword")
	public static final Item block = null;
	public OPSwordItem(AariumModElements instance) {
		super(instance, 159);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 100000f;
			}

			public float getAttackDamage() {
				return 49996f;
			}

			public int getHarvestLevel() {
				return 100000;
			}

			public int getEnchantability() {
				return 100000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, 96f, new Item.Properties().group(null)) {
		}.setRegistryName("op_sword"));
	}
}
