
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

import net.mcreator.aarium.procedure.ProcedureSwimmingLeggingsTickEvent;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemSwimming extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:swimminghelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("aarium:swimmingbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("aarium:swimminglegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("aarium:swimmingboots")
	public static final Item boots = null;
	public ItemSwimming(ElementsAariumMod instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SWIMMING", "aarium:lightium", 10, new int[]{1, 0, 0, 0}, 35,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureSwimmingLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("swimminglegs").setRegistryName("swimminglegs").setCreativeTab(CreativeTabs.TRANSPORTATION));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("aarium:swimminglegs", "inventory"));
	}
}
