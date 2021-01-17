package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.item.EntityXPOrb;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureIthenariumoreBlockDestroyedByPlayer extends ElementsAariumMod.ModElement {
	public ProcedureIthenariumoreBlockDestroyedByPlayer(ElementsAariumMod instance) {
		super(instance, 319);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure IthenariumoreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure IthenariumoreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure IthenariumoreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IthenariumoreBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (!world.isRemote) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 8));
			}
		}
	}
}
