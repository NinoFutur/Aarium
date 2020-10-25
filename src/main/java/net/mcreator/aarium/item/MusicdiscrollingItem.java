
package net.mcreator.aarium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.aarium.AariumModElements;

@AariumModElements.ModElement.Tag
public class MusicdiscrollingItem extends AariumModElements.ModElement {
	@ObjectHolder("aarium:musicdiscrolling")
	public static final Item block = null;
	public MusicdiscrollingItem(AariumModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AariumModElements.sounds.get(new ResourceLocation("aarium:this_is_my_rolling")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("musicdiscrolling");
		}
	}
}
