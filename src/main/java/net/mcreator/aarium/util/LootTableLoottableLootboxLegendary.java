
package net.mcreator.aarium.util;

@ElementsAariumMod.ModElement.Tag
public class LootTableLoottableLootboxLegendary extends ElementsAariumMod.ModElement {

	public LootTableLoottableLootboxLegendary(ElementsAariumMod instance) {
		super(instance, 409);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("aarium", "loottable_lootbox_legendary"));
	}

}
