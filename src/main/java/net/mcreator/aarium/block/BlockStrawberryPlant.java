
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockStrawberryPlant extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:strawberry_plant")
	public static final Block block = null;

	public BlockStrawberryPlant(ElementsAariumMod instance) {
		super(instance, 165);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("aarium:strawberry_plant", "inventory"));
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
		if (dimID == WorldSkyaria.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("plains")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		for (int i = 0; i < 1; i++) {
			int l6 = chunkX + random.nextInt(16) + 8;
			int i11 = random.nextInt(128);
			int l14 = chunkZ + random.nextInt(16) + 8;
			(new WorldGenReed() {
				@Override
				public boolean generate(World world, Random random, BlockPos pos) {
					for (int i = 0; i < 20; ++i) {
						BlockPos blockpos1 = pos.add(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
						if (world.isAirBlock(blockpos1)) {
							BlockPos blockpos2 = blockpos1.down();
							int j = 1 + random.nextInt(random.nextInt(3) + 1);
							j = Math.min(3, j);
							for (int k = 0; k < j; ++k)
								if (((BlockReed) block).canBlockStay(world, blockpos1))
									world.setBlockState(blockpos1.up(k), block.getDefaultState(), 2);
						}
					}
					return true;
				}
			}).generate(world, random, new BlockPos(l6, i11, l14));
		}

	}

	public static class BlockCustomFlower extends BlockReed {

		public BlockCustomFlower() {
			setSoundType(SoundType.PLANT);
			setCreativeTab(CreativeTabs.FOOD);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setUnlocalizedName("strawberry_plant");
			setRegistryName("strawberry_plant");

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
			drops.add(new ItemStack(ItemStrawberry.block, (int) (2)));
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
		public boolean canPlaceBlockAt(World world, BlockPos pos) {
			Block block2 = world.getBlockState(pos.down()).getBlock();
			return (block2.canSustainPlant(world.getBlockState(pos.down()), world, pos.down(), EnumFacing.UP, this) || block2 == block);
		}

		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess p_149720_1_, BlockPos pos, int pass) {
			return 16777215;
		}

		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {

			if (world.getBlockState(pos.down()).getBlock() == block || this.checkForDrop(world, pos, state)) {
				if (world.isAirBlock(pos.up())) {
					int l;
					for (l = 1; world.getBlockState(pos.down(l)).getBlock() == this; ++l);
					if (l < 3) {
						int i1 = (Integer) state.getValue(AGE);
						if (i1 == 15) {
							world.setBlockState(pos.up(), this.getDefaultState());
							world.setBlockState(pos, state.withProperty(AGE, 0), 4);
						} else {
							world.setBlockState(pos, state.withProperty(AGE, i1 + 1), 4);
						}
					}
				}
			}
		}

	}
}
