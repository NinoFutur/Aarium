
package net.mcreator.aarium.item;

@ElementsAariumMod.ModElement.Tag
public class ItemAirSword extends ElementsAariumMod.ModElement {

	@GameRegistry.ObjectHolder("aarium:air_sword")
	public static final Item block = null;

	public ItemAirSword(ElementsAariumMod instance) {
		super(instance, 348);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("AIR_SWORD", 3, 2000, 6f, 0f, 14)) {

			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.7000000000000002, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 3);
				return ret.keySet();
			}

		}.setUnlocalizedName("air_sword").setRegistryName("air_sword").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("aarium:air_sword", "inventory"));
	}

}
