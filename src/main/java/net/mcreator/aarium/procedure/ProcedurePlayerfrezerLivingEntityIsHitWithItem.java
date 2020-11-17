package net.mcreator.aarium.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedurePlayerfrezerLivingEntityIsHitWithItem extends ElementsAariumMod.ModElement {
	public ProcedurePlayerfrezerLivingEntityIsHitWithItem(ElementsAariumMod instance) {
		super(instance, 155);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		double X = 0;
		double Y = 0;
		double Z = 0;
		X = (double) x;
		Y = (double) y;
		Z = (double) z;
		for (int index0 = 0; index0 < (int) (3000); index0++) {
			entity.setPositionAndUpdate((X), (Y), (Z));
		}
	}
}
