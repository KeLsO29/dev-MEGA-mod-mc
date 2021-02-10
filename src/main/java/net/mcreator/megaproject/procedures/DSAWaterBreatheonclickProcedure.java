package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAWaterBreatheonclickProcedure extends MegaProjectModElements.ModElement {

	public DSAWaterBreatheonclickProcedure(MegaProjectModElements instance) {
		super(instance, 271);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAWaterBreatheonclick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_WaterBreathe) == (false))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_WaterBreathe = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Breathe ON"), (true));
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_WaterBreathe = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Breathe OFF"), (true));
			}
		}

	}

}
