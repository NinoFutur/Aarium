
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Set;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemLightiumPickaxe extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:lightium_pickaxe")
	public static final Item block = null;
	public ItemLightiumPickaxe(ElementsAariumMod instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("LIGHTIUM_PICKAXE", 5, 5000, 60f, 3.5f, 50)) {
			{
				this.attackSpeed = -2.49f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("lightium_pickaxe").setRegistryName("lightium_pickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:lightium_pickaxe", "inventory"));
	}
}
