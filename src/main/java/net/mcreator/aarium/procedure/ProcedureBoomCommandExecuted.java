package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;
import java.util.HashMap;

@ElementsAariumMod.ModElement.Tag
public class ProcedureBoomCommandExecuted extends ElementsAariumMod.ModElement {
	public ProcedureBoomCommandExecuted(ElementsAariumMod instance) {
		super(instance, 411);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BoomCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure BoomCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BoomCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BoomCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BoomCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BoomCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double BoomForce = 0;
		BoomForce = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()));
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) (BoomForce), true);
		}
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString((("Explosion confirm\u00E9e (") + "" + ("x : ") + "" + (x) + ""
					+ (", y : ") + "" + (y) + "" + (", z : ") + "" + (z) + "" + (", force : ") + "" + ((BoomForce)) + "" + (") !"))), (true));
		}
	}
}
