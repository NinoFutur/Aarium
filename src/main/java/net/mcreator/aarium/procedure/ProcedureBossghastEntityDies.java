package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.item.EntityXPOrb;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureBossghastEntityDies extends ElementsAariumMod.ModElement {
	public ProcedureBossghastEntityDies(ElementsAariumMod instance) {
		super(instance, 177);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BossghastEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BossghastEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BossghastEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BossghastEntityDies!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (50); index0++) {
			if (!world.isRemote) {
				world.spawnEntity(new EntityXPOrb(world, x, (y + 5), z, (int) 0));
			}
		}
	}
}
