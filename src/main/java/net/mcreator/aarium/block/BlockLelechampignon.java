
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockLelechampignon extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:lelechampignon")
	public static final Block block = null;

	public BlockLelechampignon(ElementsAariumMod instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("aarium:lelechampignon", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;

		if (dimID == 0)
			dimensionCriteria = true;
		if (dimID == WorldSpawn.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldEvent.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingwood.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingstone.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingdirt.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldFarmingobsidian.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldAquaria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSiberia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldPateria.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldForestia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSolitudia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldIgnisia.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldSkyaria.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("forest")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		for (int i = 0; i < 1; i++) {
			int l6 = chunkX + random.nextInt(16) + 8;
			int i11 = random.nextInt(128);
			int l14 = chunkZ + random.nextInt(16) + 8;
			(new WorldGenFlowers(((BlockFlower) block), BlockFlower.EnumFlowerType.DANDELION)).generate(world, random, new BlockPos(l6, i11, l14));
		}

	}

	public static class BlockCustomFlower extends BlockFlower {

		public BlockCustomFlower() {
			setSoundType(SoundType.PLANT);
			setCreativeTab(CreativeTabs.DECORATIONS);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(1F);
			setUnlocalizedName("lelechampignon");
			setRegistryName("lelechampignon");

		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 100;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 60;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.CONCRETE, (int) (10), 0));
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
		}

		@Override
		public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
			return EnumPlantType.Plains;
		}

		@Override
		public BlockFlower.EnumFlowerColor getBlockType() {
			return BlockFlower.EnumFlowerColor.YELLOW;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void getSubBlocks(CreativeTabs tab, net.minecraft.util.NonNullList<ItemStack> list) {
			for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(this.getBlockType())) {
				list.add(new ItemStack(this, 1, blockflower$enumflowertype.getMeta()));
			}
		}

	}
}
