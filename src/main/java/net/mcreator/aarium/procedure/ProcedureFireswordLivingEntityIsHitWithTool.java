package net.mcreator.aarium.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureFireswordLivingEntityIsHitWithTool extends ElementsAariumMod.ModElement {
	public ProcedureFireswordLivingEntityIsHitWithTool(ElementsAariumMod instance) {
		super(instance, 275);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireswordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Fire = 0;
		Fire = (double) (5 + (Math.random() * Math.pow((Math.random() + 2), (Math.random() + 2))));
		entity.setFire((int) (Fire));
	}
}
