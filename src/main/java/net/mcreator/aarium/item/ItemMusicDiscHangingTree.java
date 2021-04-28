
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemMusicDiscHangingTree extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:music_disc_hanging_tree")
	public static final Item block = null;

	public ItemMusicDiscHangingTree(ElementsAariumMod instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:music_disc_hanging_tree", "inventory"));
	}

	public static class MusicDiscItemCustom extends ItemRecord {

		public MusicDiscItemCustom() {
			super("music_disc_hanging_tree", ElementsAariumMod.sounds.get(new ResourceLocation("aarium:the_hanging_tree_remix_hunger_games")));
			setUnlocalizedName("music_disc_hanging_tree");
			setRegistryName("music_disc_hanging_tree");
			setCreativeTab(CreativeTabs.MISC);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("Credits to James Newton Howard");
		}

	}

}
