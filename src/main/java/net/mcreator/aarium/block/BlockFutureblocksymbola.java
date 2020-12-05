
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFutureblocksymbola extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:futureblocksymbola")
	public static final Block block = null;

	public BlockFutureblocksymbola(ElementsAariumMod instance) {
		super(instance, 296);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("futureblocksymbola"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:futureblocksymbola", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("futureblocksymbola");
			setSoundType(SoundType.METAL);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
