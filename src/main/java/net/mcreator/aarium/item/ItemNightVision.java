
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

import net.mcreator.aarium.procedure.ProcedureNightVisionHelmetTickEvent;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemNightVision extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:night_visionhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("aarium:night_visionbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("aarium:night_visionlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("aarium:night_visionboots")
	public static final Item boots = null;
	public ItemNightVision(ElementsAariumMod instance) {
		super(instance, 155);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("NIGHT_VISION", "aarium:aarium_armor", 25, new int[]{0, 0, 0, 1}, 35,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.note.chime")), 1f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureNightVisionHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("night_visionhelmet").setRegistryName("night_visionhelmet").setCreativeTab(CreativeTabs.TRANSPORTATION));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("aarium:night_visionhelmet", "inventory"));
	}
}
