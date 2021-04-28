
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockInfectedAir1 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:infected_air_1")
	public static final Block block = null;

	public BlockInfectedAir1(ElementsAariumMod instance) {
		super(instance, 404);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("infected_air_1"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:infected_air_1", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.AIR);

			setUnlocalizedName("infected_air_1");
			setSoundType(SoundType.CLOTH);

			setHardness(0F);
			setResistance(10000F);
			setLightLevel(0F);
			setLightOpacity(50);
			setCreativeTab(CreativeTabs.DECORATIONS);
			setBlockUnbreakable();

		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.CUTOUT_MIPPED;
		}

		@Override
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isReplaceable(IBlockAccess blockAccess, BlockPos pos) {
			return true;
		}

		@Override
		public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
			super.onEntityCollidedWithBlock(world, pos, state, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureInfectedAir1QuandLentiteEntreEnCollisionAvecLeBloc.executeProcedure($_dependencies);
			}
		}

	}

}
