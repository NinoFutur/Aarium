
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemSuperbreaker extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:superbreaker")
	public static final Item block = null;

	public ItemSuperbreaker(ElementsAariumMod instance) {
		super(instance, 230);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, IBlockState bl, BlockPos pos, EntityLivingBase entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);

					ProcedureSuperbreakerBlockDestroyedWithTool.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setUnlocalizedName("superbreaker").setRegistryName("superbreaker").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:superbreaker", "inventory"));
	}

	private static class ItemToolCustom extends Item {

		protected ItemToolCustom() {
			setMaxDamage(2000);
			setMaxStackSize(1);
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", -2f, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3.5, 0));
			}
			return multimap;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			IBlockState require;
			require = Blocks.STONE.getStateFromMeta(0);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(1);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(2);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(3);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(4);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(5);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			require = Blocks.STONE.getStateFromMeta(6);
			try {
				if ((par2Block.getBlock() == require.getBlock())
						&& (par2Block.getBlock().getMetaFromState(par2Block) == require.getBlock().getMetaFromState(require)))
					return 8f;
			} catch (Exception e) {
				if (par2Block.getBlock() == require.getBlock())
					return 8f;
			}
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
			stack.damageItem(1, entityLiving);
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
			stack.damageItem(2, attacker);
			return true;
		}

		@Override
		public boolean isFull3D() {
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 45;
		}

	}

}
