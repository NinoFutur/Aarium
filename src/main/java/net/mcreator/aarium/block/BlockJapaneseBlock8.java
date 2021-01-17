
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapaneseBlock8 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanese_block_8")
	public static final Block block = null;

	public BlockJapaneseBlock8(ElementsAariumMod instance) {
		super(instance, 194);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanese_block_8"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanese_block_8", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.WOOD);

			setUnlocalizedName("japanese_block_8");
			setSoundType(SoundType.WOOD);

			setHarvestLevel("axe", -1);

			setHardness(1F);
			setResistance(30F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionJapan.tab);

		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 10;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 15;
		}

	}

}
