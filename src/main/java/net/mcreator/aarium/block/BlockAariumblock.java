
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockAariumblock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:aariumblock")
	public static final Block block = null;

	public BlockAariumblock(ElementsAariumMod instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("aariumblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:aariumblock", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("aariumblock");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 4);

			setHardness(5F);
			setResistance(30F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
