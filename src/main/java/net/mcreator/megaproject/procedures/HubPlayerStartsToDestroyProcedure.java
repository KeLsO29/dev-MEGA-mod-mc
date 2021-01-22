package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class HubPlayerStartsToDestroyProcedure extends MegaProjectModElements.ModElement {

	public HubPlayerStartsToDestroyProcedure(MegaProjectModElements instance) {
		super(instance, 46);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HubPlayerStartsToDestroy!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Materials and Energy Saved."), (false));
		}

	}

}
