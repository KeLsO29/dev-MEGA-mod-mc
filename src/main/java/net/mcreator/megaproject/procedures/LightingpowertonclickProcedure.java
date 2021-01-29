package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class LightingpowertonclickProcedure extends MegaProjectModElements.ModElement {

	public LightingpowertonclickProcedure(MegaProjectModElements instance) {
		super(instance, 192);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Lightingpowertonclick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("LightingPower")) == (true))) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putBoolean("LightingPower", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lighting Power Deactivated"), (false));
			}
		} else {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putBoolean("LightingPower", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lighting Power Activated"), (false));
			}
		}

	}

}
