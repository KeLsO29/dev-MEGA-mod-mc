package net.mcreator.megaproject.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DSNightVisionONCLICKProcedure extends MegaProjectModElements.ModElement {
	public DSNightVisionONCLICKProcedure(MegaProjectModElements instance) {
		super(instance, 224);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSNightVisionONCLICK!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_NightVision) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_NightVision = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Night Vision OFF"), (true));
			}
		} else {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_NightVision = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Night Vision ON"), (true));
			}
		}
	}
}
