
package net.mcreator.aarium.item.crafting;

@ElementsAariumMod.ModElement.Tag
public class RecipeSmeltedcocoarecipe extends ElementsAariumMod.ModElement {

	public RecipeSmeltedcocoarecipe(ElementsAariumMod instance) {
		super(instance, 276);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.DYE, (int) (1), 3), new ItemStack(ItemSmeltedcocoa.block, (int) (1)), 1F);
	}

}
