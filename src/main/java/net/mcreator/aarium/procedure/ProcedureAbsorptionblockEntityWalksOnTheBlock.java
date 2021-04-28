package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureAbsorptionblockEntityWalksOnTheBlock extends ElementsAariumMod.ModElement {

	public ProcedureAbsorptionblockEntityWalksOnTheBlock(ElementsAariumMod instance) {
		super(instance, 244);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AbsorptionblockEntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, (int) 600,
					(int) ((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).experienceLevel : 0), (false), (false)));

	}

}
