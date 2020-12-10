
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockSpeedBlock3 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:speed_block_3")
	public static final Block block = null;

	public BlockSpeedBlock3(ElementsAariumMod instance) {
		super(instance, 335);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("speed_block_3"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:speed_block_3", "inventory"));

	}

	public static class BlockCustom extends Block {

		public static final PropertyDirection FACING = BlockHorizontal.FACING;

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("speed_block_3");
			setSoundType(SoundType.METAL);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.REDSTONE);

			setDefaultSlipperiness(1.2999999999999998f);

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

	}

}
