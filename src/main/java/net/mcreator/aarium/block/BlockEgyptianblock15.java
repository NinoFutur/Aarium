
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockEgyptianblock15 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:egyptianblock_15")
	public static final Block block = null;

	@GameRegistry.ObjectHolder("aarium:egyptianblock_15_double")
	public static final Block block_slab_double = null;

	public BlockEgyptianblock15(ElementsAariumMod instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("egyptianblock_15"));
		elements.blocks.add(() -> new BlockCustom.Double().setRegistryName("egyptianblock_15_double"));
		elements.items.add(() -> new ItemSlab(block, (BlockSlab) block, (BlockSlab) block_slab_double).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:egyptianblock_15", "inventory"));

	}

	public static class BlockCustom extends BlockSlab {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("egyptianblock_15");
			setSoundType(SoundType.SAND);

			setHarvestLevel("pickaxe", 2);

			setHardness(2F);
			setResistance(20F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionegypt.tab);

			IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, BlockCustom.Variant.DEFAULT);
			if (!this.isDouble())
				state = state.withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
			this.setDefaultState(state);
			this.useNeighborBrightness = !this.isDouble();

		}

		public static final PropertyEnum<BlockCustom.Variant> VARIANT = PropertyEnum.<BlockCustom.Variant>create("variant",
				BlockCustom.Variant.class);

		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return Item.getItemFromBlock(block);
		}

		@Override
		public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
			return new ItemStack(block);
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return this.isDouble()
					? new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{VARIANT})
					: new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{HALF, VARIANT});
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			if (this.isDouble()) {
				return this.getDefaultState();
			} else {
				return this.getDefaultState().withProperty(HALF, BlockSlab.EnumBlockHalf.values()[meta % 2]);
			}
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			if (this.isDouble()) {
				return 0;
			} else {
				return state.getValue(HALF).ordinal();
			}
		}

		@Override
		public String getUnlocalizedName(int meta) {
			return super.getUnlocalizedName();
		}

		@Override
		public IProperty<?> getVariantProperty() {
			return VARIANT;
		}

		@Override
		public Comparable<?> getTypeForItem(ItemStack stack) {
			return BlockCustom.Variant.DEFAULT;
		}

		@Override
		public boolean isDouble() {
			return false;
		}

		@Override
		public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
			if (isDouble())
				return true;
			return super.doesSideBlockRendering(state, world, pos, face);
		}

		public enum Variant implements IStringSerializable {
			DEFAULT;

			public String getName() {
				return "default";
			}
		}

		public static class Double extends BlockCustom {

			@Override
			public boolean isDouble() {
				return true;
			}
		}

	}

}
