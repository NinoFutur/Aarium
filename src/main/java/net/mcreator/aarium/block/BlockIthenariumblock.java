
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockIthenariumblock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:ithenariumblock")
	public static final Block block = null;

	public BlockIthenariumblock(ElementsAariumMod instance) {
		super(instance, 256);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ithenariumblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:ithenariumblock", "inventory"));

	}

	public static class BlockCustom extends BlockFalling {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("ithenariumblock");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 3);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0.33F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
