
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLaptop extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:laptop")
	public static final Block block = null;

	public BlockLaptop(ElementsAariumMod instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("laptop"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:laptop", "inventory"));

	}

	public static class BlockCustom extends Block {

		public static final PropertyDirection FACING = BlockHorizontal.FACING;

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("laptop");
			setSoundType(SoundType.METAL);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.DECORATIONS);

			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			switch ((EnumFacing) state.getValue(BlockHorizontal.FACING)) {
				case SOUTH :
				default :
					return new AxisAlignedBB(0, 0, 0, 0, 0, 0)
							.union(new AxisAlignedBB(11.199999999999999, 0, 11.199999999999999, 4.8, 4.800000000000001, 4.799999999999999));
				case NORTH :
					return new AxisAlignedBB(0, 0, 0, 0, 0, 0)
							.union(new AxisAlignedBB(4.800000000000001, 0, 4.800000000000001, 11.2, 4.800000000000001, 11.200000000000001));
				case EAST :
					return new AxisAlignedBB(0, 0, 0, 0, 0, 0)
							.union(new AxisAlignedBB(11.199999999999999, 0, 4.800000000000001, 4.799999999999999, 4.800000000000001, 11.2));
				case WEST :
					return new AxisAlignedBB(0, 0, 0, 0, 0, 0)
							.union(new AxisAlignedBB(4.800000000000001, 0, 11.199999999999999, 11.200000000000001, 4.800000000000001, 4.8));
			}
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
