
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Set;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemAariumHoe extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:aarium_hoe")
	public static final Item block = null;
	public ItemAariumHoe(ElementsAariumMod instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("AARIUM_HOE", 4, 2000, 15f, 0f, 14)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 4);
				return ret.keySet();
			}
		}.setUnlocalizedName("aarium_hoe").setRegistryName("aarium_hoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:aarium_hoe", "inventory"));
	}
}
