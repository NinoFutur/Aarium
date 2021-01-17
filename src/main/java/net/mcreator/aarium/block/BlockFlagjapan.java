
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFlagjapan extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:flagjapan")
	public static final Block block = null;

	public BlockFlagjapan(ElementsAariumMod instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("flagjapan"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:flagjapan", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CIRCUITS);

			setUnlocalizedName("flagjapan");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(40F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionJapan.tab);

		}

	}

}
