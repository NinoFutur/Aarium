package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureFarmingstonePlayerEntersDimension extends ElementsAariumMod.ModElement {
	public ProcedureFarmingstonePlayerEntersDimension(ElementsAariumMod instance) {
		super(instance, 156);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FarmingstonePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FarmingstonePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FarmingstonePlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FarmingstonePlayerEntersDimension!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
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
			}, "tellraw @a [\"\",{\"selector\":\"@p\",\"color\":\"green\"},{\"text\":\" va chercher de la pierre !\",\"color\":\"gray\"},{\"text\":\"\\n\"},{\"text\":\"[Le rejoindre !]\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/execute in aarium:farmingstone run tp @p 0 70 0\"}}]");
		}
	}
}
