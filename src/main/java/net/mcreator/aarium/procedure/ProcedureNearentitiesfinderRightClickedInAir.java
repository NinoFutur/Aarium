package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.aarium.item.ItemNearentitiesfinder;
import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureNearentitiesfinderRightClickedInAir extends ElementsAariumMod.ModElement {
	public ProcedureNearentitiesfinderRightClickedInAir(ElementsAariumMod instance) {
		super(instance, 176);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure NearentitiesfinderRightClickedInAir!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double Cooldown = 0;
		if (sourceentity instanceof EntityPlayer)
			((EntityPlayer) sourceentity).getCooldownTracker().setCooldown((new ItemStack(ItemNearentitiesfinder.block, (int) (1))).getItem(),
					(int) 600);
		{
			Entity _ent = sourceentity;
			if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
				_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
						return _ent.world;
					}

					@Override
					public MinecraftServer getServer() {
						return _ent.world.getMinecraftServer();
					}

					@Override
					public boolean sendCommandFeedback() {
						return false;
					}

					@Override
					public BlockPos getPosition() {
						return _ent.getPosition();
					}

					@Override
					public Vec3d getPositionVector() {
						return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
					}

					@Override
					public Entity getCommandSenderEntity() {
						return _ent;
					}
				}, "effect @e[c=25,x=~,y=~,z=~,rm=1,r=50] minecraft:glowing 15 1 true");
			}
		}
	}
}
