
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLaddertrapdoor extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:laddertrapdoor")
	public static final Block block = null;

	public BlockLaddertrapdoor(ElementsAariumMod instance) {
		super(instance, 249);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("laddertrapdoor"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:laddertrapdoor", "inventory"));

	}

	public static class BlockCustom extends BlockTrapDoor {

		public BlockCustom() {
			super(Material.WOOD);

			setUnlocalizedName("laddertrapdoor");
			setSoundType(SoundType.WOOD);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.REDSTONE);

		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
			return true;
		}

	}

}
