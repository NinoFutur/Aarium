
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.aarium.procedures.FireswordLivingEntityIsHitWithToolProcedure;
import net.mcreator.aarium.AariumModElements;

import java.util.Map;
import java.util.HashMap;

@AariumModElements.ModElement.Tag
public class FireswordItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:firesword")
	public static final Item block = null;
	public FireswordItem(AariumModElements instance) {
		super(instance, 165);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.LAVA_BUCKET, (int) (1)), new ItemStack(Items.BLAZE_POWDER, (int) (1)));
			}
		}, 3, -3.5f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					FireswordLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("firesword"));
	}
}
