package net.mcreator.aarium.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureFoodblockEntityWalksOnTheBlock extends ElementsAariumMod.ModElement {
	public ProcedureFoodblockEntityWalksOnTheBlock(ElementsAariumMod instance) {
		super(instance, 313);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FoodblockEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 50);
	}
}
