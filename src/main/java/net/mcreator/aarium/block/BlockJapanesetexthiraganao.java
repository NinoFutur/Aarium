
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganao extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganao")
	public static final Block block = null;

	public BlockJapanesetexthiraganao(ElementsAariumMod instance) {
		super(instance, 226);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganao"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganao", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CLOTH);

			setUnlocalizedName("japanesetexthiraganao");
			setSoundType(SoundType.CLOTH);

			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);

		}

	}

}
