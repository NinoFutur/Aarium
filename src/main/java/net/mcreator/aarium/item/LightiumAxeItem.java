
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.aarium.block.LightiumOreBlockBlock;
import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class LightiumAxeItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:lightium_axe")
	public static final Item block = null;
	public LightiumAxeItem(AariumModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 50000;
			}

			public float getEfficiency() {
				return 50f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 50000;
			}

			public int getEnchantability() {
				return 5000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LightiumOreBlockBlock.block, (int) (1)));
			}
		}, 1, -2.2f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("lightium_axe"));
	}
}
