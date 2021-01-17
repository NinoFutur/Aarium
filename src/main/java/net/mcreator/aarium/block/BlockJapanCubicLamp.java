
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanCubicLamp extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japan_cubic_lamp")
	public static final Block block = null;

	public BlockJapanCubicLamp(ElementsAariumMod instance) {
		super(instance, 192);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japan_cubic_lamp"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japan_cubic_lamp", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.WOOD);

			setUnlocalizedName("japan_cubic_lamp");
			setSoundType(SoundType.WOOD);

			setHarvestLevel("axe", 0);

			setHardness(1.2F);
			setResistance(20F);
			setLightLevel(0.95F);
			setLightOpacity(0);
			setCreativeTab(TabCollectionJapan.tab);

		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.125D, 0D, 0.125D, 0.875D, 1D, 0.875D);
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

	}

}
