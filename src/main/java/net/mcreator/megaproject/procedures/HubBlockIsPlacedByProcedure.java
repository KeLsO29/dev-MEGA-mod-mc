package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class HubBlockIsPlacedByProcedure extends MegaProjectModElements.ModElement {
	public HubBlockIsPlacedByProcedure(MegaProjectModElements instance) {
		super(instance, 37);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HubBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure HubBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure HubBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure HubBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HubBlockIsPlacedBy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).placed_hub) == (false))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Coal", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Iron", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Caterium", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Energy", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Production", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Consume", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			MegaProjectModVariables.MapVariables.get(world).hub_x = (double) x;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			MegaProjectModVariables.MapVariables.get(world).hub_y = (double) y;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			MegaProjectModVariables.MapVariables.get(world).hub_z = (double) z;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("New hub.") + "" + ("Hub Location") + ""
						+ ((MegaProjectModVariables.MapVariables.get(world).hub_x)) + "" + ((MegaProjectModVariables.MapVariables.get(world).hub_y))
						+ "" + ((MegaProjectModVariables.MapVariables.get(world).hub_z)))), (false));
			}
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.placed_hub = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).placed_hub) == (true))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Coal", ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).hub_coal_save));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Iron", ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).hub_iron_save));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Caterium", (MegaProjectModVariables.MapVariables.get(world).hub_caterium_save));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Energy", (MegaProjectModVariables.MapVariables.get(world).hub_energy_save));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			MegaProjectModVariables.MapVariables.get(world).hub_x = (double) x;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			MegaProjectModVariables.MapVariables.get(world).hub_y = (double) y;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			MegaProjectModVariables.MapVariables.get(world).hub_z = (double) z;
			MegaProjectModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Hub Loaded, ") + "" + ("Hub Location") + ""
						+ ((MegaProjectModVariables.MapVariables.get(world).hub_x)) + "" + ((MegaProjectModVariables.MapVariables.get(world).hub_y))
						+ "" + ((MegaProjectModVariables.MapVariables.get(world).hub_z)))), (false));
			}
		}
	}
}
