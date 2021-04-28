
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFutureblock0 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:futureblock_0")
	public static final Block block = null;

	public BlockFutureblock0(ElementsAariumMod instance) {
		super(instance, 295);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("futureblock_0"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:futureblock_0", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("futureblock_0");
			setSoundType(SoundType.METAL);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
