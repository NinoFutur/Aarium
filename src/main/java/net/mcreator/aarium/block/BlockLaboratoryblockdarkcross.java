
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLaboratoryblockdarkcross extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:laboratoryblockdarkcross")
	public static final Block block = null;

	public BlockLaboratoryblockdarkcross(ElementsAariumMod instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("laboratoryblockdarkcross"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:laboratoryblockdarkcross", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("laboratoryblockdarkcross");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 3);

			setHardness(3F);
			setResistance(50F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

		@Override
		public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
			return true;
		}

	}

}
