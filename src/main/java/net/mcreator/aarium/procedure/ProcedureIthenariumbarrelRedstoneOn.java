package net.mcreator.aarium.procedure;

import net.minecraft.world.World;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureIthenariumbarrelRedstoneOn extends ElementsAariumMod.ModElement {
	public ProcedureIthenariumbarrelRedstoneOn(ElementsAariumMod instance) {
		super(instance, 260);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure IthenariumbarrelRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure IthenariumbarrelRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure IthenariumbarrelRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IthenariumbarrelRedstoneOn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (1); index0++) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 10, true);
			}
		}
	}
}
