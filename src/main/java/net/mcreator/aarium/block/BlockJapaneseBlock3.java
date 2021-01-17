
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapaneseBlock3 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanese_block_3")
	public static final Block block = null;

	public BlockJapaneseBlock3(ElementsAariumMod instance) {
		super(instance, 186);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanese_block_3"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanese_block_3", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GLASS);

			setUnlocalizedName("japanese_block_3");
			setSoundType(SoundType.GLASS);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(40F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabCollectionJapan.tab);

		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.CUTOUT_MIPPED;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

	}

}
