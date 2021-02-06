package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class ClearlagExecutedProcedure extends MegaProjectModElements.ModElement {

	public ClearlagExecutedProcedure(MegaProjectModElements instance) {
		super(instance, 259);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ClearlagExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/kill @e[type=minecraft:item]");
			}
		}

	}

}
