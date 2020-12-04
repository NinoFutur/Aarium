
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockReinforcedsteelblock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:reinforcedsteelblock")
	public static final Block block = null;

	public BlockReinforcedsteelblock(ElementsAariumMod instance) {
		super(instance, 289);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("reinforcedsteelblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:reinforcedsteelblock", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("reinforcedsteelblock");
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
