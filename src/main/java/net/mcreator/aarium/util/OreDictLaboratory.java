
package net.mcreator.aarium.util;

@ElementsAariumMod.ModElement.Tag
public class OreDictLaboratory extends ElementsAariumMod.ModElement {

	public OreDictLaboratory(ElementsAariumMod instance) {
		super(instance, 210);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblock.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblockdarkline.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblockdarklinesborder.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblockdarkcross.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblocktrue.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblockfalse.block, (int) (1)));
		OreDictionary.registerOre("laboratory", new ItemStack(ItemLaboratoryblockwarning.block, (int) (1)));
	}

}
