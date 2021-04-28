
package net.mcreator.aarium.item.crafting;

@ElementsAariumMod.ModElement.Tag
public class RecipeIthenariumingotfromblock extends ElementsAariumMod.ModElement {

	public RecipeIthenariumingotfromblock(ElementsAariumMod instance) {
		super(instance, 255);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockIthenariumore.block, (int) (1)), new ItemStack(ItemIthenariumingot.block, (int) (1)), 5F);
	}

}
