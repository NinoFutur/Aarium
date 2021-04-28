
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockPolishedAariumBlock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:polished_aarium_block")
	public static final Block block = null;

	public BlockPolishedAariumBlock(ElementsAariumMod instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("polished_aarium_block"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:polished_aarium_block", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("polished_aarium_block");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 4);

			setHardness(3.5F);
			setResistance(150F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
