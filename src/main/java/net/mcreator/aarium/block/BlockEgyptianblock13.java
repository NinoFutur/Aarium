
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockEgyptianblock13 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:egyptianblock_13")
	public static final Block block = null;

	public BlockEgyptianblock13(ElementsAariumMod instance) {
		super(instance, 103);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("egyptianblock_13"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:egyptianblock_13", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("egyptianblock_13");
			setSoundType(SoundType.SAND);

			setHarvestLevel("pickaxe", 2);

			setHardness(2F);
			setResistance(20F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabCollectionegypt.tab);

		}

	}

}
