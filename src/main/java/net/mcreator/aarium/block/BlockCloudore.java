
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockCloudore extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:cloudore")
	public static final Block block = null;

	public BlockCloudore(ElementsAariumMod instance) {
		super(instance, 412);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("cloudore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:cloudore", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.SNOW);

			setUnlocalizedName("cloudore");
			setSoundType(SoundType.SNOW);

			setHardness(0.7999999999999999F);
			setResistance(10000F);
			setLightLevel(0F);
			setLightOpacity(125);
			setCreativeTab(CreativeTabs.MISC);

		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.AIR;
		}

	}

}
