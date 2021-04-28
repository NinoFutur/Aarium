
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganai extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganai")
	public static final Block block = null;

	public BlockJapanesetexthiraganai(ElementsAariumMod instance) {
		super(instance, 225);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganai"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganai", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CLOTH);

			setUnlocalizedName("japanesetexthiraganai");
			setSoundType(SoundType.CLOTH);

			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);

		}

	}

}
