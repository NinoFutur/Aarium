
package net.mcreator.aarium.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class ItemMusicdiscrolling extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:musicdiscrolling")
	public static final Item block = null;
	public ItemMusicdiscrolling(ElementsAariumMod instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:musicdiscrolling", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("musicdiscrolling", ElementsAariumMod.sounds.get(new ResourceLocation("aarium:this_is_my_rolling")));
			setUnlocalizedName("musicdiscrolling");
			setRegistryName("musicdiscrolling");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
