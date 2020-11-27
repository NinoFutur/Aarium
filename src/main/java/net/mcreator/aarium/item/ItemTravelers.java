
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

import net.mcreator.aarium.procedure.ProcedureTravelersBootsTickEvent;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemTravelers extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:travelershelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("aarium:travelersbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("aarium:travelerslegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("aarium:travelersboots")
	public static final Item boots = null;
	public ItemTravelers(ElementsAariumMod instance) {
		super(instance, 107);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("TRAVELERS", "aarium:lightium", 10, new int[]{1, 5, 0, 0}, 35,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 1f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureTravelersBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("travelersboots").setRegistryName("travelersboots").setCreativeTab(CreativeTabs.TRANSPORTATION));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("aarium:travelersboots", "inventory"));
	}
}
