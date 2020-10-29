
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class LightiumPickaxeItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:lightium_pickaxe")
	public static final Item block = null;
	public LightiumPickaxeItem(AariumModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 5000;
			}

			public float getEfficiency() {
				return 60f;
			}

			public float getAttackDamage() {
				return 5.5f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.49f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("lightium_pickaxe"));
	}
}
