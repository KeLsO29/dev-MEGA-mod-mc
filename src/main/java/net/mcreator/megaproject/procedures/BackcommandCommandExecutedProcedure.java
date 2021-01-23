package net.mcreator.megaproject.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;
import java.util.Collections;

@MegaProjectModElements.ModElement.Tag
public class BackcommandCommandExecutedProcedure extends MegaProjectModElements.ModElement {
	public BackcommandCommandExecutedProcedure(MegaProjectModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BackcommandCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(
					((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_x),
					((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_y),
					((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_z));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(
						((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_x),
						((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_y),
						((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).player_back_z),
						_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
			}
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You was returned to your previous location."), (false));
		}
	}
}
