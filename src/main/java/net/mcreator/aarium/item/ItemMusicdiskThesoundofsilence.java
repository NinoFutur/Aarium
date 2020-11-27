
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
public class ItemMusicdiskThesoundofsilence extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:musicdisk_thesoundofsilence")
	public static final Item block = null;
	public ItemMusicdiskThesoundofsilence(ElementsAariumMod instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:musicdisk_thesoundofsilence", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("musicdisk_thesoundofsilence", ElementsAariumMod.sounds.get(new ResourceLocation("aarium:the_sound_of_silence")));
			setUnlocalizedName("musicdisk_thesoundofsilence");
			setRegistryName("musicdisk_thesoundofsilence");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
