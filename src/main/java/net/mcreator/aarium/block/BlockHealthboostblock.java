
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockHealthboostblock extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:healthboostblock")
	public static final Block block = null;

	public BlockHealthboostblock(ElementsAariumMod instance) {
		super(instance, 246);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("healthboostblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:healthboostblock", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.IRON);

			setUnlocalizedName("healthboostblock");
			setSoundType(SoundType.METAL);

			setHarvestLevel("pickaxe", 2);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.REDSTONE);

		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ProcedureHealthboostblockEntityWalksOnTheBlock.executeProcedure($_dependencies);
			}
		}

	}

}
