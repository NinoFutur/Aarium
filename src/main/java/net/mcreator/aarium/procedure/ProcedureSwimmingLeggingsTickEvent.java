package net.mcreator.aarium.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureSwimmingLeggingsTickEvent extends ElementsAariumMod.ModElement {
	public ProcedureSwimmingLeggingsTickEvent(ElementsAariumMod instance) {
		super(instance, 239);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SwimmingLeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, (int) 240, (int) 3));
	}
}
