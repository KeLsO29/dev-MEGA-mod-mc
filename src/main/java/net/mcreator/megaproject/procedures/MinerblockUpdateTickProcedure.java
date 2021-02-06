package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;

import net.mcreator.megaproject.block.MinerinactiveBlock;
import net.mcreator.megaproject.block.LimestoneactiveBlock;
import net.mcreator.megaproject.block.IronOreNodeBlockBlock;
import net.mcreator.megaproject.block.CopperNodeBlock;
import net.mcreator.megaproject.block.CoalNodeBlock;
import net.mcreator.megaproject.block.CateriumNODEblockBlock;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class MinerblockUpdateTickProcedure extends MegaProjectModElements.ModElement {
	public MinerblockUpdateTickProcedure(MegaProjectModElements instance) {
		super(instance, 43);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
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
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(
				new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
						(int) (MegaProjectModVariables.MapVariables.get(world).hub_y), (int) (MegaProjectModVariables.MapVariables.get(world).hub_z)),
				"Energy")) >= 5)) {
			if ((CoalNodeBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
					.getBlock())) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Wokirng", (true));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if ((Math.random() < 0.5)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
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
							}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Coal")) + 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
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
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 5));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else if ((IronOreNodeBlockBlock.block.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Wokirng", (true));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if ((Math.random() < 0.5)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
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
							}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Iron")) + 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
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
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 5));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else if ((CateriumNODEblockBlock.block.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Wokirng", (true));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if ((Math.random() < 0.3)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
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
							}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Caterium")) + 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
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
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 5));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else if ((CopperNodeBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
					.getBlock())) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Wokirng", (true));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if ((Math.random() < 0.3)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("Copper", ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Copper")) + 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
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
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 5));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else if ((LimestoneactiveBlock.block.getDefaultState()
					.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())) {
				if ((Math.random() < 0.45)) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("Wokirng", (true));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
								(int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("SandStone", ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "SandStone")) + 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
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
									(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 5));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Wokirng", (false));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = MinerinactiveBlock.block.getDefaultState();
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
		} else {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("Wokirng", (false));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = MinerinactiveBlock.block.getDefaultState();
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
