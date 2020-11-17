package net.mcreator.aarium.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.aarium.AariumModElements;

import java.util.Map;

@AariumModElements.ModElement.Tag
public class FireswordLivingEntityIsHitWithToolProcedure extends AariumModElements.ModElement {
	public FireswordLivingEntityIsHitWithToolProcedure(AariumModElements instance) {
		super(instance, 165);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FireswordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Fire = 0;
		Fire = (double) (5 + (Math.random() * Math.pow((Math.random() + 2), (Math.random() + 2))));
		entity.setFire((int) (Fire));
	}
}
