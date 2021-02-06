package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class LimestoneactiveUpdateTickProcedure extends MegaProjectModElements.ModElement {

	public LimestoneactiveUpdateTickProcedure(MegaProjectModElements instance) {
		super(instance, 235);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure LimestoneactiveUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure LimestoneactiveUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure LimestoneactiveUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure LimestoneactiveUpdateTick!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((!((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.SANDSTONE.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.SANDSTONE.getDefaultState().getBlock()))
				&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.SANDSTONE.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.SANDSTONE.getDefaultState()
								.getBlock()))))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = LimestoneinactiveItem.block.getDefaultState();

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
		}

	}

}
