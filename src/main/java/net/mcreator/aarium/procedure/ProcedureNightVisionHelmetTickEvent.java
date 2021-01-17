package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureNightVisionHelmetTickEvent extends ElementsAariumMod.ModElement {

	public ProcedureNightVisionHelmetTickEvent(ElementsAariumMod instance) {
		super(instance, 393);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NightVisionHelmetTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, (int) 60, (int) 0, (false), (false)));

	}

}
