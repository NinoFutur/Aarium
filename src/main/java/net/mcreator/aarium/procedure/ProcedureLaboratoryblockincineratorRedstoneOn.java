package net.mcreator.aarium.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureLaboratoryblockincineratorRedstoneOn extends ElementsAariumMod.ModElement {
	public ProcedureLaboratoryblockincineratorRedstoneOn(ElementsAariumMod instance) {
		super(instance, 298);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LaboratoryblockincineratorRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LaboratoryblockincineratorRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LaboratoryblockincineratorRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LaboratoryblockincineratorRedstoneOn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.FLAME, x, (y + 1), z, (int) 50, 0, 3, 0, 10, new int[0]);
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) (y + 1), (int) z, false));
	}
}
