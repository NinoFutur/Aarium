
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
				case UP :
				case DOWN :
				case SOUTH :
				default :
					return new AxisAlignedBB(0.7D, 0D, 0.7D, 0.3D, 0.3D, 0.2999999999999999D);
				case NORTH :
					return new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.3D, 0.7000000000000001D);
				case WEST :
					return new AxisAlignedBB(0.3D, 0D, 0.7D, 0.7000000000000001D, 0.3D, 0.3D);
				case EAST :
					return new AxisAlignedBB(0.7D, 0D, 0.3D, 0.2999999999999999D, 0.3D, 0.7D);
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
