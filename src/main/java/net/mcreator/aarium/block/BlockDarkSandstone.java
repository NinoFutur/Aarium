
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockDarkSandstone extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:dark_sandstone")
	public static final Block block = null;

	public BlockDarkSandstone(ElementsAariumMod instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("dark_sandstone"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:dark_sandstone", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.SAND);

			setUnlocalizedName("dark_sandstone");
			setSoundType(SoundType.SAND);

			setHarvestLevel("pickaxe", 1);

			setHardness(1F);
			setResistance(30F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
