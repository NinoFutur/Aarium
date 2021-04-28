
package net.mcreator.aarium.block;

@ElementsAariumMod.ModElement.Tag
public class BlockAcid extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:acid")
	public static final Block block = null;

	@GameRegistry.ObjectHolder("aarium:acid")
	public static final Item item = null;

	private Fluid fluid;

	public BlockAcid(ElementsAariumMod instance) {
		super(instance, 229);
		fluid = new Fluid("acid", new ResourceLocation("aarium:blocks/acid_still"), new ResourceLocation("aarium:blocks/acid_flow")).setLuminosity(10)
				.setDensity(980).setViscosity(150).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {

			@Override
			public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
				super.updateTick(world, pos, state, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					ProcedureAcidUpdateTick.executeProcedure($_dependencies);
				}
				world.scheduleUpdate(new BlockPos(x, y, z), this, this.tickRate(world));
			}

			@Override
			public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
				super.onEntityCollidedWithBlock(world, pos, state, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("entity", entity);

					ProcedureAcidMobplayerCollidesBlock.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("acid").setRegistryName("acid"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("acid"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("aarium:acid", "acid");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("aarium:acid", "acid");
			}
		});
	}

}
