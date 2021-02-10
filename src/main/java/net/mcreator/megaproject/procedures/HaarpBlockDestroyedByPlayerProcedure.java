package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class HaarpBlockDestroyedByPlayerProcedure extends MegaProjectModElements.ModElement {

	public HaarpBlockDestroyedByPlayerProcedure(MegaProjectModElements instance) {
		super(instance, 220);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure HaarpBlockDestroyedByPlayer!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");

		world.getWorld().getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set((true), world.getWorld().getServer());
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("HAARP DEACTIVATED!"));
		}

	}

}
