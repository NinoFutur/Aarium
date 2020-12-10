
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFakeDirt extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:fake_dirt")
	public static final Block block = null;

	public BlockFakeDirt(ElementsAariumMod instance) {
		super(instance, 344);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("fake_dirt"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:fake_dirt", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GROUND);

			setUnlocalizedName("fake_dirt");
			setSoundType(SoundType.GROUND);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
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

	}

}
