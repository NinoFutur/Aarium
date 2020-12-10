package net.mcreator.aarium.procedure;

@ElementsAariumMod.ModElement.Tag
public class ProcedureAirSwordLivingEntityIsHitWithTool extends ElementsAariumMod.ModElement {

	public ProcedureAirSwordLivingEntityIsHitWithTool(ElementsAariumMod instance) {
		super(instance, 348);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AirSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AirSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AirSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AirSwordLivingEntityIsHitWithTool!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");

		entity.setPositionAndUpdate(x, (y + 10), z);

	}

}
