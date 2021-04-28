
package net.mcreator.aarium.item.crafting;

@ElementsAariumMod.ModElement.Tag
public class RecipeHotmilkchocolaterecipe extends ElementsAariumMod.ModElement {

	public RecipeHotmilkchocolaterecipe(ElementsAariumMod instance) {
		super(instance, 283);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemColdmilkchocolate.block, (int) (1)), new ItemStack(ItemHotmilkchocolate.block, (int) (1)), 1F);
	}

}
