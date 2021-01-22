package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class MinerblockUpdateTickProcedure extends MegaProjectModElements.ModElement {

	public MinerblockUpdateTickProcedure(MegaProjectModElements instance) {
		super(instance, 43);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MinerblockUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure MinerblockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure MinerblockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure MinerblockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure MinerblockUpdateTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((CoalNodeBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
			if ((Math.random() < 0.7)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos(
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Coal", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos(
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z)),
								"Coal")) + 1));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else if ((IronOreNodeBlockBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
				.getBlock())) {
			if ((Math.random() < 0.7)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos(
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Iron", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos(
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z)),
								"Iron")) + 1));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else if ((CateriumNODEblockBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
				.getBlock())) {
			if ((Math.random() < 0.4)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos(
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
							(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Caterium", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos(
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_x),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_y),
								(int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new MegaProjectModVariables.PlayerVariables())).hub_z)),
								"Caterium")) + 1));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}

	}

}
