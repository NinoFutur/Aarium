package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedurePoisonousMushroomEntityCollidesInTheBlock extends ElementsAariumMod.ModElement {

	public ProcedurePoisonousMushroomEntityCollidesInTheBlock(ElementsAariumMod instance) {
		super(instance, 327);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PoisonousMushroomEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, (int) 60, (int) 3, (false), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 200, (int) 1, (false), (false)));

	}

}
