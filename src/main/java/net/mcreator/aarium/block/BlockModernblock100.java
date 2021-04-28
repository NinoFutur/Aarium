
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockModernblock100 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:modernblock_100")
	public static final Block block = null;

	public BlockModernblock100(ElementsAariumMod instance) {
		super(instance, 100);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("modernblock_100"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:modernblock_100", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GRASS);

			setUnlocalizedName("modernblock_100");
			setSoundType(SoundType.GROUND);

			setHardness(1.4000000000000001F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);

		}

	}

}
