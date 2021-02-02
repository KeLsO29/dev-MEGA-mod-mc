package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class AssemblerblockUpdateTickProcedure extends MegaProjectModElements.ModElement {

	public AssemblerblockUpdateTickProcedure(MegaProjectModElements instance) {
		super(instance, 212);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AssemblerblockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AssemblerblockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AssemblerblockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AssemblerblockUpdateTick!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((200 < (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(
				new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
						(int) (MegaProjectModVariables.MapVariables.get(world).hub_y), (int) (MegaProjectModVariables.MapVariables.get(world).hub_z)),
				"Energy")))) {
			if ((((((new Object() {
				public int getAmount(BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) >= 6) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(CateriumIngotItem.block, (int) (1))
					.getItem())) && (((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) >= 3) && ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)))
							.getItem() == new ItemStack(CopperSheetItemItem.block, (int) (1)).getItem())))
					&& ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))
							.getItem() == new ItemStack(CircuitBoarditemItem.block, (int) (1)).getItem()) && ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) < 64)) || ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(CateriumIngotItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 6));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(CopperSheetItemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) - 3));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = new ItemStack(CircuitBoarditemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Energy", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 200));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((((new Object() {
				public int getAmount(BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) >= 1) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(ScrewItem.block, (int) (1)).getItem()))
					&& (((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) >= 1) && ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == new ItemStack(Items.DIAMOND, (int) (1))
							.getItem())))
					&& ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))
							.getItem() == new ItemStack(DiamondscrewitemItem.block, (int) (1)).getItem()) && ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) < 64)) || ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(ScrewItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(Items.DIAMOND, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) - 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = new ItemStack(DiamondscrewitemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Energy", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 200));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((((new Object() {
				public int getAmount(BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) >= 8) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.COAL, (int) (1)).getItem()))
					&& (((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) >= 1) && ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == new ItemStack(Items.REDSTONE, (int) (1))
							.getItem())))
					&& ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(TurbofuelitemItem.block, (int) (1))
							.getItem()) && ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) < 64)) || ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(Items.COAL, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 8));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(Items.REDSTONE, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) - 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = new ItemStack(TurbofuelitemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Energy", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 200));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((((new Object() {
				public int getAmount(BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) >= 4) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(ScrewItem.block, (int) (1)).getItem()))
					&& (((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) >= 5) && ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == new ItemStack(Items.IRON_INGOT, (int) (1))
							.getItem())))
					&& ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(IronplateItem.block, (int) (1))
							.getItem()) && ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) < 64)) || ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(ScrewItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 4));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(Items.IRON_INGOT, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) - 5));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = new ItemStack(IronplateItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Energy", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 200));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((((new Object() {
				public int getAmount(BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) >= 8) && ((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(CateriumroditemItem.block, (int) (1))
					.getItem())) && (((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) >= 1) && ((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == new ItemStack(Blocks.IRON_BLOCK, (int) (1))
							.getItem())))
					&& ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2)))
							.getItem() == new ItemStack(CateriumwireitemItem.block, (int) (1)).getItem()) && ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) < 64)) || ((new Object() {
								public int getAmount(BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(CateriumroditemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 8));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) - 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = new ItemStack(CateriumwireitemItem.block, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Energy", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 200));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (false));

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("Working", (false));

				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}

	}

}
