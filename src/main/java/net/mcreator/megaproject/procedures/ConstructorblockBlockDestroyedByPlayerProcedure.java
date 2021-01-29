package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class ConstructorblockBlockDestroyedByPlayerProcedure extends MegaProjectModElements.ModElement {
	public ConstructorblockBlockDestroyedByPlayerProcedure(MegaProjectModElements instance) {
		super(instance, 178);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ConstructorblockBlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		MegaProjectModVariables.MapVariables
				.get(world).total_comsuption = (double) ((MegaProjectModVariables.MapVariables.get(world).total_comsuption) - 20);
		MegaProjectModVariables.MapVariables.get(world).syncData(world);
	}
}
