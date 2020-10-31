package net.mcreator.aarium.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.item.PlayerfrezerItem;
import net.mcreator.aarium.AariumModElements;

import java.util.Map;

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
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure PlayerfrezerLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof PlayerEntity)
				? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(PlayerfrezerItem.block, (int) (1)))
				: false)) {
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(PlayerfrezerItem.block, (int) (1));
				((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3000, (int) 255, (false), (false)));
		}
	}
}
