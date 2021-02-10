package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class PermadayshowcondidionProcedure extends MegaProjectModElements.ModElement {

	public PermadayshowcondidionProcedure(MegaProjectModElements instance) {
		super(instance, 216);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Permadayshowcondidion!");
			return false;
		}

		IWorld world = (IWorld) dependencies.get("world");

		if (((MegaProjectModVariables.MapVariables.get(world).haarp_permaday) == (true))) {
			return (true);
		}
		return (false);

	}

}
