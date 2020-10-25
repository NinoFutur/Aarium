
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class MusicdiskThesoundofsilenceItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:musicdisk_thesoundofsilence")
	public static final Item block = null;
	public MusicdiskThesoundofsilenceItem(AariumModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AariumModElements.sounds.get(new ResourceLocation("aarium:the_sound_of_silence")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("musicdisk_thesoundofsilence");
		}
	}
}
