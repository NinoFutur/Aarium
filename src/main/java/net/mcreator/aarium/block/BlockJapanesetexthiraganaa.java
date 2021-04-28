
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganaa extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganaa")
	public static final Block block = null;

	public BlockJapanesetexthiraganaa(ElementsAariumMod instance) {
		super(instance, 223);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganaa"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganaa", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CLOTH);

			setUnlocalizedName("japanesetexthiraganaa");
			setSoundType(SoundType.CLOTH);

			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);

		}

	}

}
