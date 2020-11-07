package net.mcreator.aarium.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.AariumModElements;

import java.util.Map;
import java.util.Collections;

@AariumModElements.ModElement.Tag
public class PlayerfrezerLivingEntityIsHitWithItemProcedure extends AariumModElements.ModElement {
	public PlayerfrezerLivingEntityIsHitWithItemProcedure(AariumModElements instance) {
		super(instance, 155);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double X = 0;
		double Y = 0;
		double Z = 0;
		X = (double) x;
		Y = (double) y;
		Z = (double) z;
		for (int index0 = 0; index0 < (int) (3000); index0++) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((X), (Y), (Z));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((X), (Y), (Z), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
		}
	}
}
