
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockSolidair extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:solidair")
	public static final Block block = null;

	public BlockSolidair(ElementsAariumMod instance) {
		super(instance, 139);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("solidair"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:solidair", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("solidair");
			setSoundType(SoundType.GROUND);

			setHarvestLevel("pickaxe", 2);

			setHardness(1.5F);
			setResistance(20F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

	}

}
