
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockSteelstairs extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:steelstairs")
	public static final Block block = null;

	public BlockSteelstairs(ElementsAariumMod instance) {
		super(instance, 291);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("steelstairs"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:steelstairs", "inventory"));

	}

	public static class BlockCustom extends BlockStairs {

		public BlockCustom() {
			super(new Block(Material.IRON).getDefaultState());

			setUnlocalizedName("steelstairs");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 3);

			setHardness(1.5F);
			setResistance(100F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
