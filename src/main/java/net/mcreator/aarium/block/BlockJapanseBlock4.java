
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanseBlock4 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanse_block_4")
	public static final Block block = null;

	public BlockJapanseBlock4(ElementsAariumMod instance) {
		super(instance, 187);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanse_block_4"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:japanse_block_4", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CIRCUITS);

			setUnlocalizedName("japanse_block_4");
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
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

	}

}
