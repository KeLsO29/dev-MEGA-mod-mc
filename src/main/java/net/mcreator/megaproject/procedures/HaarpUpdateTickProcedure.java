package net.mcreator.megaproject.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;

import net.mcreator.megaproject.block.HeavyframeBlock;
import net.mcreator.megaproject.block.HaarpinactiveBlock;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class HaarpUpdateTickProcedure extends MegaProjectModElements.ModElement {
	public HaarpUpdateTickProcedure(MegaProjectModElements instance) {
		super(instance, 214);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure HaarpUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure HaarpUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure HaarpUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HaarpUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double heavyframes = 0;
		double iteration = 0;
		boolean counted = false;
		iteration = (double) 1;
		heavyframes = (double) 0;
		for (int index0 = 0; index0 < (int) (128); index0++) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - (iteration)), (int) z))).getBlock() == HeavyframeBlock.block.getDefaultState()
					.getBlock())) {
				heavyframes = (double) ((heavyframes) + 1);
			}
			iteration = (double) ((iteration) + 1);
		}
		if (((heavyframes) < 128)) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = HaarpinactiveBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			world.getWorld().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set((true), world.getWorld().getServer());
			counted = (boolean) (false);
		}
		if ((((MegaProjectModVariables.MapVariables.get(world).haarp_permaday) == (true)) && ((counted) == (false)))) {
			world.getWorld().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set((false), world.getWorld().getServer());
			if (world instanceof World)
				world.getWorld().setDayTime((int) 1);
			counted = (boolean) (true);
		}
	}
}
