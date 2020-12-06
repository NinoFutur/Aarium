
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockMegaithenariumbarrel extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:megaithenariumbarrel")
	public static final Block block = null;

	public BlockMegaithenariumbarrel(ElementsAariumMod instance) {
		super(instance, 298);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("megaithenariumbarrel"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:megaithenariumbarrel", "inventory"));

	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.ROCK);

			setUnlocalizedName("megaithenariumbarrel");
			setSoundType(SoundType.METAL);

			setHarvestLevel("axe", 2);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0.4F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.REDSTONE);

		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);

					ProcedureMegaithenariumbarrelRedstoneOn.executeProcedure($_dependencies);
				}
			} else {
			}
		}

		@Override
		public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion e) {
			super.onBlockDestroyedByExplosion(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				ProcedureMegaithenariumbarrelRedstoneOn.executeProcedure($_dependencies);
			}
		}

	}

}
