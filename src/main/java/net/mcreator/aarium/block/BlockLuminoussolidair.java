
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLuminoussolidair extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:luminoussolidair")
	public static final Block block = null;

	public BlockLuminoussolidair(ElementsAariumMod instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("luminoussolidair"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:luminoussolidair", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("luminoussolidair");
			setSoundType(SoundType.GROUND);

			setHarvestLevel("pickaxe", 2);

			setHardness(1.5F);
			setResistance(20F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);

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

	}

}
