package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.material.Material;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureTreechopperBlockDestroyedWithTool extends ElementsAariumMod.ModElement {
	public ProcedureTreechopperBlockDestroyedWithTool(ElementsAariumMod instance) {
		super(instance, 286);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TreechopperBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TreechopperBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TreechopperBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TreechopperBlockDestroyedWithTool!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double AX = 0;
		double AY = 0;
		double AZ = 0;
		for (int index0 = 0; index0 < (int) (1); index0++) {
			AX = (double) x;
			AY = (double) y;
			AZ = (double) z;
		}
		if (((world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ)))).getMaterial() == Material.WOOD)) {
			world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ))).getBlock().dropBlockAsItem(world,
					new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ))), 1);
			world.setBlockToAir(new BlockPos((int) (AX), (int) (AY), (int) (AZ)));
		}
		AX = (double) ((x - 5) % 5);
		for (int index1 = 0; index1 < (int) (100); index1++) {
			AX = (double) ((x + 1) % 5);
			AY = (double) y;
			AZ = (double) (z - 5);
			if (((world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ)))).getMaterial() == Material.WOOD)) {
				world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ))).getBlock().dropBlockAsItem(world,
						new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (AX), (int) (AY), (int) (AZ))), 1);
				world.setBlockToAir(new BlockPos((int) (AX), (int) (AY), (int) (AZ)));
			}
		}
	}
}
