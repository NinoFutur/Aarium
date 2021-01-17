
package net.mcreator.aarium.util;

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
