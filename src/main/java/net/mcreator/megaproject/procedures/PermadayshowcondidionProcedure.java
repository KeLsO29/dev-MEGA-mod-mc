package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

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
