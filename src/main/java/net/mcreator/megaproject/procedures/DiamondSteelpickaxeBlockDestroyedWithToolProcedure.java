package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Random;
import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelpickaxeBlockDestroyedWithToolProcedure extends MegaProjectModElements.ModElement {
	public DiamondSteelpickaxeBlockDestroyedWithToolProcedure(MegaProjectModElements instance) {
		super(instance, 168);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelpickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DiamondSteelpickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DiamondSteelpickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DiamondSteelpickaxeBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DiamondSteelpickaxeBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("3x3")) == (true))) {
			if (((((entity.getHorizontalFacing()) == Direction.NORTH) || ((entity.getHorizontalFacing()) == Direction.SOUTH))
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.ROCK))) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), false);
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			if (((((entity.getHorizontalFacing()) == Direction.WEST) || ((entity.getHorizontalFacing()) == Direction.EAST))
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.ROCK))) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))), world.getWorld(),
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), false);
				{
					ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		}
	}
}
