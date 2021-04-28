
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockHiddenblock3 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:hiddenblock_3")
	public static final Block block = null;

	public BlockHiddenblock3(ElementsAariumMod instance) {
		super(instance, 236);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("hiddenblock_3"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:hiddenblock_3", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("hiddenblock_3");
			setSoundType(SoundType.METAL);

			setHardness(1F);
			setResistance(10000F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.DECORATIONS);

		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("Cheh");
		}

	}

}
