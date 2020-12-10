package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureChaosCommandExecuted extends ElementsAariumMod.ModElement {
	public ProcedureChaosCommandExecuted(ElementsAariumMod instance) {
		super(instance, 341);
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
		boolean Z = false;
		for (int index0 = 0; index0 < (int) (100); index0++) {
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * 30) + x), (int) y, (int) ((Math.random() * 30) + z), false));
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * (-30)) + x), (int) y, (int) ((Math.random() * (-30)) + z), false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) ((Math.random() * (-30)) + z), false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) ((Math.random() * (-30)) + x), (int) y, (int) z, false));
		}
		for (int index1 = 0; index1 < (int) (100); index1++) {
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * (-10)) + x), (int) y, (int) ((Math.random() * (-30)) + z), false));
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * 10) + x), (int) y, (int) ((Math.random() * 30) + z), false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) ((Math.random() * 10) + z), false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) ((Math.random() * 10) + x), (int) y, (int) z, false));
		}
		for (int index2 = 0; index2 < (int) (100); index2++) {
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * (-30)) + x), (int) y, (int) ((Math.random() * (-10)) + z), false));
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * 30) + x), (int) y, (int) ((Math.random() * 10) + z), false));
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * 30) + x), (int) y, (int) ((Math.random() * 30) + z), false));
			world.addWeatherEffect(
					new EntityLightningBolt(world, (int) ((Math.random() * 30) - x), (int) y, (int) ((Math.random() * 30) - z), false));
		}
	}
}
