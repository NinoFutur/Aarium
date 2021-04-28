
package net.mcreator.aarium.util;

@ElementsAariumMod.ModElement.Tag
public class OreDictEgypt extends ElementsAariumMod.ModElement {

	public OreDictEgypt(ElementsAariumMod instance) {
		super(instance, 212);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock0.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock1.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock2.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock3.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock4.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock5.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock6.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock70.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock71.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianBlock8.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(BlockEgyptianblock9.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock10.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock11.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock12.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock13.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock14.block, (int) (1)));
		OreDictionary.registerOre("egypt", new ItemStack(ItemEgyptianblock15.block, (int) (1)));
	}

}
