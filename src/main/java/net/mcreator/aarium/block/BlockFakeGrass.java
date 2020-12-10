
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFakeGrass extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:fake_grass")
	public static final Block block = null;

	public BlockFakeGrass(ElementsAariumMod instance) {
		super(instance, 346);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("fake_grass"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:fake_grass", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GRASS);

			setUnlocalizedName("fake_grass");
			setSoundType(SoundType.GROUND);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.REDSTONE);

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

	}

}
