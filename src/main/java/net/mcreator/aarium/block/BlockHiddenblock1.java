
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockHiddenblock1 extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:hiddenblock_1")
	public static final Block block = null;

	public BlockHiddenblock1(ElementsAariumMod instance) {
		super(instance, 234);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("hiddenblock_1"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:hiddenblock_1", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("hiddenblock_1");
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
			list.add("Rip");
		}

	}

}
