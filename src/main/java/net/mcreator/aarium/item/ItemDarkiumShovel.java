
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Set;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ItemDarkiumShovel extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:darkium_shovel")
	public static final Item block = null;
	public ItemDarkiumShovel(ElementsAariumMod instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("DARKIUM_SHOVEL", 5, 6280, 24f, 1f, 140)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("darkium_shovel").setRegistryName("darkium_shovel").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:darkium_shovel", "inventory"));
	}
}
