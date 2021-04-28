
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLightiumOreBlock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:lightium_ore_block")
	public static final Block block = null;

	public BlockLightiumOreBlock(ElementsAariumMod instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("lightium_ore_block"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:lightium_ore_block", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("lightium_ore_block");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 5);

			setHardness(12F);
			setResistance(50000F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		}

	}

}
