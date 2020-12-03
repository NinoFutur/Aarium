
package net.mcreator.aarium.item.crafting;

@ElementsAariumMod.ModElement.Tag
public class RecipeCacaofondurecipe extends ElementsAariumMod.ModElement {

	public RecipeCacaofondurecipe(ElementsAariumMod instance) {
		super(instance, 265);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.DYE, (int) (1), 3), new ItemStack(ItemCacaofondu.block, (int) (1)), 1F);
	}

}
