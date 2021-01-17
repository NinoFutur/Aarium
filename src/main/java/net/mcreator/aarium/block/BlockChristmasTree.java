
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockChristmasTree extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:christmas_tree")
	public static final Block block = null;

	public BlockChristmasTree(ElementsAariumMod instance) {
		super(instance, 406);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("christmas_tree"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:christmas_tree", "inventory"));

	}

	public static class BlockCustom extends Block {

		public static final PropertyDirection FACING = BlockHorizontal.FACING;

		public BlockCustom() {
			super(Material.PLANTS);

			setUnlocalizedName("christmas_tree");
			setSoundType(SoundType.SNOW);

			setHardness(0.4F);
			setResistance(20F);
			setLightLevel(1F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.DECORATIONS);

			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{FACING});
		}

		@Override
		public IBlockState withRotation(IBlockState state, Rotation rot) {
			return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
		}

		@Override
		public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
			return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((EnumFacing) state.getValue(FACING)).getIndex();
		}

		@Override
		public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
				EntityLivingBase placer) {
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

	}

}
