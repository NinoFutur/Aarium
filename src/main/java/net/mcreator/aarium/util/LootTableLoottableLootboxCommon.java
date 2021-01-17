
package net.mcreator.aarium.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class LootTableLoottableLootboxCommon extends ElementsAariumMod.ModElement {
	public LootTableLoottableLootboxCommon(ElementsAariumMod instance) {
		super(instance, 407);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("aarium", "loottable_lootbox_common"));
	}
}
