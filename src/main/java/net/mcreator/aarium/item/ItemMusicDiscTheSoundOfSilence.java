
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
public class ItemMusicDiscTheSoundOfSilence extends ElementsAariumMod.ModElement {
	@GameRegistry.ObjectHolder("aarium:music_disc_the_sound_of_silence")
	public static final Item block = null;
	public ItemMusicDiscTheSoundOfSilence(ElementsAariumMod instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:music_disc_the_sound_of_silence", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("music_disc_the_sound_of_silence", ElementsAariumMod.sounds.get(new ResourceLocation("aarium:the_sound_of_silence")));
			setUnlocalizedName("music_disc_the_sound_of_silence");
			setRegistryName("music_disc_the_sound_of_silence");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
