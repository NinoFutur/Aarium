
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockSakuraSushisSign extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:sakura_sushis_sign")
	public static final Block block = null;

	public BlockSakuraSushisSign(ElementsAariumMod instance) {
		super(instance, 193);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("sakura_sushis_sign"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:sakura_sushis_sign", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("sakura_sushis_sign");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 2);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionJapan.tab);

		}

	}

}
