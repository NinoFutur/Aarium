
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganau extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganau")
	public static final Block block = null;

	public BlockJapanesetexthiraganau(ElementsAariumMod instance) {
		super(instance, 227);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganau"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganau", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CLOTH);

			setUnlocalizedName("japanesetexthiraganau");
			setSoundType(SoundType.CLOTH);

			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);

		}

	}

}
