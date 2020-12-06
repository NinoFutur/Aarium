package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureFireswordRightClickedInAir extends ElementsAariumMod.ModElement {

	public ProcedureFireswordRightClickedInAir(ElementsAariumMod instance) {
		super(instance, 296);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FireswordRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FireswordRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FireswordRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FireswordRightClickedInAir!");
			return;
		}

		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		for (int index0 = 0; index0 < (int) (1); index0++) {
			world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0, 0, 0);
		}

	}

}
