
package net.mcreator.aarium.item.crafting;

@ElementsAariumMod.ModElement.Tag
public class RecipeChocolatchaudrecipe extends ElementsAariumMod.ModElement {

	public RecipeChocolatchaudrecipe(ElementsAariumMod instance) {
		super(instance, 272);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemChocolataulaitfroidfood.block, (int) (1)), new ItemStack(ItemChocolatchaud.block, (int) (1)), 1F);
	}

}
