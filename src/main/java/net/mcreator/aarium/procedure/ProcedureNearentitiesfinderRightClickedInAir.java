package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.command.ICommandSender;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;
import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureNearentitiesfinderRightClickedInAir extends ElementsAariumMod.ModElement {
	public ProcedureNearentitiesfinderRightClickedInAir(ElementsAariumMod instance) {
		super(instance, 277);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double Cooldown = 0;
		if (!world.isRemote && world.getMinecraftServer() != null) {
			world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
				@Override
				public String getName() {
					return "";
				}

				@Override
				public boolean canUseCommand(int permission, String command) {
					return true;
				}

				@Override
				public World getEntityWorld() {
					return world;
				}

				@Override
				public MinecraftServer getServer() {
					return world.getMinecraftServer();
				}

				@Override
				public boolean sendCommandFeedback() {
					return false;
				}

				@Override
				public BlockPos getPosition() {
					return new BlockPos((int) x, (int) y, (int) z);
				}

				@Override
				public Vec3d getPositionVector() {
					return new Vec3d(x, y, z);
				}
			}, "effect @e[c=25,x=~,y=~,z=~,rm=1,r=15] minecraft:glowing 15 1 true");
		}
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setItemDamage(0);
			}
		}
	}
}
