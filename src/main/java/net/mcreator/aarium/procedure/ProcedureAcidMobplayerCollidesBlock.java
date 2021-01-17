package net.mcreator.aarium.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureAcidMobplayerCollidesBlock extends ElementsAariumMod.ModElement {
	public ProcedureAcidMobplayerCollidesBlock(ElementsAariumMod instance) {
		super(instance, 306);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 50);
	}
}
