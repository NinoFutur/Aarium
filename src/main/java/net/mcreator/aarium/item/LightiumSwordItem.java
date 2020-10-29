
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
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
				return 5000;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 11.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LightiumGemItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("lightium_sword"));
	}
}
