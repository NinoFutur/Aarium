package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureFireswordLivingEntityIsHitWithTool2 extends ElementsAariumMod.ModElement {

	public ProcedureFireswordLivingEntityIsHitWithTool2(ElementsAariumMod instance) {
		super(instance, 297);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireswordLivingEntityIsHitWithTool2!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FireswordLivingEntityIsHitWithTool2!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FireswordLivingEntityIsHitWithTool2!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FireswordLivingEntityIsHitWithTool2!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FireswordLivingEntityIsHitWithTool2!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		for (int index0 = 0; index0 < (int) (1); index0++) {
			entity.setFire((int) 10);
			for (int index1 = 0; index1 < (int) (5); index1++) {
				world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0, 0, 0);
			}
		}

	}

}
