
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFlagThailand extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:flag_thailand")
	public static final Block block = null;

	public BlockFlagThailand(ElementsAariumMod instance) {
		super(instance, 130);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("flag_thailand"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:flag_thailand", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CIRCUITS);

			setUnlocalizedName("flag_thailand");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 0);

			setHardness(1F);
			setResistance(40F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);

		}

	}

}
