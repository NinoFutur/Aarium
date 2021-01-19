
package net.mcreator.aarium.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.aarium.ElementsAariumMod;

@ElementsAariumMod.ModElement.Tag
public class LootTableLoottableLootboxRare extends ElementsAariumMod.ModElement {
	public LootTableLoottableLootboxRare(ElementsAariumMod instance) {
		super(instance, 408);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("aarium", "loottable_lootbox_rare"));
	}
}
