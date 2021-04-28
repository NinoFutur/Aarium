
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockJapanesetexthiraganae extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:japanesetexthiraganae")
	public static final Block block = null;

	public BlockJapanesetexthiraganae(ElementsAariumMod instance) {
		super(instance, 224);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("japanesetexthiraganae"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:japanesetexthiraganae", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CLOTH);

			setUnlocalizedName("japanesetexthiraganae");
			setSoundType(SoundType.CLOTH);

			setHardness(1F);
			setResistance(25F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(null);

		}

	}

}
