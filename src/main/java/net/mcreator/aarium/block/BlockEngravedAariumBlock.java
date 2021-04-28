
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockEngravedAariumBlock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:engraved_aarium_block")
	public static final Block block = null;

	public BlockEngravedAariumBlock(ElementsAariumMod instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("engraved_aarium_block"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:engraved_aarium_block", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("engraved_aarium_block");
			setSoundType(SoundType.METAL);

			setHardness(3.5F);
			setResistance(300F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
