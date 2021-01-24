package net.mcreator.aarium.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;

import net.mcreator.aarium.ElementsAariumMod;

import java.util.Random;
import java.util.Map;

@ElementsAariumMod.ModElement.Tag
public class ProcedureSuperbreakerBlockDestroyedWithTool extends ElementsAariumMod.ModElement {
	public ProcedureSuperbreakerBlockDestroyedWithTool(ElementsAariumMod instance) {
		super(instance, 231);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure SuperbreakerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SuperbreakerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SuperbreakerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SuperbreakerBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SuperbreakerBlockDestroyedWithTool!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double CX = 0;
		double CY = 0;
		double CZ = 0;
		double GY = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.ROCK)) {
			GY = (double) (y - 1);
			for (int index0 = 0; index0 < (int) (1); index0++) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)));
				}
			}
			GY = (double) (y + 0);
			for (int index1 = 0; index1 < (int) (1); index1++) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)));
				}
			}
			GY = (double) (y + 1);
			for (int index2 = 0; index2 < (int) (1); index2++) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z - 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 0)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 1), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x - 0), (int) (GY), (int) (z + 1)));
				}
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)))).getMaterial() == Material.ROCK)) {
					world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))).getBlock().dropBlockAsItem(world,
							new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1))), 1);
					world.setBlockToAir(new BlockPos((int) (x + 1), (int) (GY), (int) (z + 1)));
				}
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 27, new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
		}
	}
}
