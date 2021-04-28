
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLaboratoryblockwarning extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:laboratoryblockwarning")
	public static final Block block = null;

	public BlockLaboratoryblockwarning(ElementsAariumMod instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("laboratoryblockwarning"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:laboratoryblockwarning", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("laboratoryblockwarning");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 3);

			setHardness(3F);
			setResistance(50F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
