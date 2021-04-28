package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureInfectedAir1QuandLentiteEntreEnCollisionAvecLeBloc extends ElementsAariumMod.ModElement {

	public ProcedureInfectedAir1QuandLentiteEntreEnCollisionAvecLeBloc(ElementsAariumMod instance) {
		super(instance, 405);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure InfectedAir1QuandLentiteEntreEnCollisionAvecLeBloc!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 200, (int) 1, (false), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 200, (int) 1, (false), (false)));

	}

}
