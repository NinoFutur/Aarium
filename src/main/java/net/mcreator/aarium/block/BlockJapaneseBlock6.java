
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapaneseBlock6 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanese_block_6")
	public static final Block block = null;

	public BlockJapaneseBlock6(ElementsAariumMod instance) {
		super(instance, 190);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanese_block_6"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanese_block_6", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("japanese_block_6");
			setSoundType(SoundType.STONE);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(40F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionJapan.tab);

		}

	}

}
