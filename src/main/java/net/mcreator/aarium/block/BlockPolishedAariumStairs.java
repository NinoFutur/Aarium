
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockPolishedAariumStairs extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:polished_aarium_stairs")
	public static final Block block = null;

	public BlockPolishedAariumStairs(ElementsAariumMod instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("polished_aarium_stairs"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:polished_aarium_stairs", "inventory"));

	}

	public static class BlockCustom extends BlockStairs {

		public BlockCustom() {
			super(new Block(Material.ROCK).getDefaultState());

			setUnlocalizedName("polished_aarium_stairs");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 4);

			setHardness(3.5F);
			setResistance(150F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
