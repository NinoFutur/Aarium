
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockReinforcedsteelstairs extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:reinforcedsteelstairs")
	public static final Block block = null;

	public BlockReinforcedsteelstairs(ElementsAariumMod instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("reinforcedsteelstairs"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:reinforcedsteelstairs", "inventory"));

	}

	public static class BlockCustom extends BlockStairs {

		public BlockCustom() {
			super(new Block(Material.IRON).getDefaultState());

			setUnlocalizedName("reinforcedsteelstairs");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 4);

			setHardness(3F);
			setResistance(1000F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
