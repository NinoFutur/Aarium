
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class DarkiumAxeItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:darkium_axe")
	public static final Item block = null;
	public DarkiumAxeItem(AariumModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3500;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 9.5f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 140;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.75f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("darkium_axe"));
	}
}
