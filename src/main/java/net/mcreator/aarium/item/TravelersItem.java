
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.procedures.TravelersBootsTickEventProcedure;
import net.mcreator.aarium.AariumModElements;

import java.util.Map;
import java.util.HashMap;

@AariumModElements.ModElement.Tag
public class TravelersItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:travelers_helmet")
	public static final Item helmet = null;
	@ObjectHolder("aarium:travelers_chestplate")
	public static final Item body = null;
	@ObjectHolder("aarium:travelers_leggings")
	public static final Item legs = null;
	@ObjectHolder("aarium:travelers_boots")
	public static final Item boots = null;
	public TravelersItem(AariumModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 10;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 5, 0, 0}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 35;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.ambient"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "travelers";
			}

			public float getToughness() {
				return 1f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.TRANSPORTATION)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aarium:textures/models/armor/lightium_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					TravelersBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("travelers_boots"));
	}
}
