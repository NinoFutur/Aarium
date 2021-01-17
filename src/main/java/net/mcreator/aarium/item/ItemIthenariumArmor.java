
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.procedure.ProcedureIthenariumArmorHelmetTickEvent;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemIthenariumArmor extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:ithenarium_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("aarium:ithenarium_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("aarium:ithenarium_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("aarium:ithenarium_armorboots")
	public static final Item boots = null;
	public ItemIthenariumArmor(ElementsAariumMod instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ITHENARIUM_ARMOR", "aarium:ithenarium", 45, new int[]{6, 18, 15, 6}, 27,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureIthenariumArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("ithenarium_armorhelmet").setRegistryName("ithenarium_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureIthenariumArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("ithenarium_armorbody").setRegistryName("ithenarium_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureIthenariumArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("ithenarium_armorlegs").setRegistryName("ithenarium_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureIthenariumArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("ithenarium_armorboots").setRegistryName("ithenarium_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("aarium:ithenarium_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("aarium:ithenarium_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("aarium:ithenarium_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("aarium:ithenarium_armorboots", "inventory"));
	}
}
