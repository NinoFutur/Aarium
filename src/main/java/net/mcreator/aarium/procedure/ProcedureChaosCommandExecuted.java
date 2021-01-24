package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureChaosCommandExecuted extends ElementsAariumMod.ModElement {
	public ProcedureChaosCommandExecuted(ElementsAariumMod instance) {
		super(instance, 381);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ChaosCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ChaosCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ChaosCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ChaosCommandExecuted!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double X = 0;
		double Y = 0;
		double Z = 0;
		double Radius_positive = 0;
		double Radius_negative = 0;
		for (int index0 = 0; index0 < (int) (10); index0++) {
			for (int index1 = 0; index1 < (int) (10); index1++) {
				X = (double) (((Radius_positive) * Math.random()) + x);
				X = (double) (((Radius_positive) * Math.random()) + y);
				Z = (double) (((Radius_positive) * Math.random()) + z);
				world.addWeatherEffect(new EntityLightningBolt(world, (int) (X), (int) (Y), (int) (Z), false));
				world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			}
			for (int index2 = 0; index2 < (int) (10); index2++) {
				X = (double) (((Radius_negative) * Math.random()) + x);
				X = (double) (((Radius_negative) * Math.random()) + y);
				Z = (double) (((Radius_negative) * Math.random()) + z);
				world.addWeatherEffect(new EntityLightningBolt(world, (int) (X), (int) (Y), (int) (Z), false));
			}
		}
	}
}
