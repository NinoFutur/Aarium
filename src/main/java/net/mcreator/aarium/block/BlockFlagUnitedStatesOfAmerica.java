
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockFlagUnitedStatesOfAmerica extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:flag_united_states_of_america")
	public static final Block block = null;

	public BlockFlagUnitedStatesOfAmerica(ElementsAariumMod instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("flag_united_states_of_america"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:flag_united_states_of_america", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.CIRCUITS);

			setUnlocalizedName("flag_united_states_of_america");
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
