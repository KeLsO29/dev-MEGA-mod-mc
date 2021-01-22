package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class HubGUIWhileThisGUIIsOpenTickProcedure extends MegaProjectModElements.ModElement {

	public HubGUIWhileThisGUIIsOpenTickProcedure(MegaProjectModElements instance) {
		super(instance, 44);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HubGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HubGUIWhileThisGUIIsOpenTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0))) == 0) && (64 < (new Object() {
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
				"Iron"))))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.IRON_ORE, (int) (1));
						_setstack.setCount((int) 64);
						((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
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
							"Iron")) - 64));

				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if ((((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (1))) == 0) && (64 < (new Object() {
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
				"Coal"))))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.COAL, (int) (1));
						_setstack.setCount((int) 64);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
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
							"Coal")) - 64));

				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if ((((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (2))) == 0) && (64 < (new Object() {
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
				"Caterium"))))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(CateriumOreBlock.block, (int) (1));
						_setstack.setCount((int) 64);
						((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
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
							"Caterium")) - 64));

				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}

	}

}
