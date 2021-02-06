package net.mcreator.megaproject.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DSASpeedonlcickProcedure extends MegaProjectModElements.ModElement {
	public DSASpeedonlcickProcedure(MegaProjectModElements instance) {
		super(instance, 225);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSASpeedonlcick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_Speed) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_Speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Speed OFF"), (true));
			}
		} else {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_Speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Speed ON"), (true));
			}
		}
	}
}
