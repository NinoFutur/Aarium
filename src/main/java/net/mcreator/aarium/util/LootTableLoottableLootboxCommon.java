
package net.mcreator.aarium.util;

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
