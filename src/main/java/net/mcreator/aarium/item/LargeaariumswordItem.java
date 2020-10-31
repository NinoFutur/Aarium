
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aarium.block.AariumblockBlock;
import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class LargeaariumswordItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:largeaariumsword")
	public static final Item block = null;
	public LargeaariumswordItem(AariumModElements instance) {
		super(instance, 162);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4500;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 16f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AariumblockBlock.block, (int) (1)));
			}
		}, 3, 76f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("largeaariumsword"));
	}
}
