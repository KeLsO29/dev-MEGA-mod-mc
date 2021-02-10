package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAdolphingraceonclickProcedure extends MegaProjectModElements.ModElement {

	public DSAdolphingraceonclickProcedure(MegaProjectModElements instance) {
		super(instance, 273);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAdolphingraceonclick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_DolphinGrace) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_DolphinGrace = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Dolphin Grace OFF"), (true));
			}
		} else {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_DolphinGrace = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Dolphin Grace ON"), (true));
			}
		}

	}

}
