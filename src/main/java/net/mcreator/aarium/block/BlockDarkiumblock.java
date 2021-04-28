
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockDarkiumblock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:darkiumblock")
	public static final Block block = null;

	public BlockDarkiumblock(ElementsAariumMod instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("darkiumblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:darkiumblock", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("darkiumblock");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 5);

			setHardness(3F);
			setResistance(500F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
