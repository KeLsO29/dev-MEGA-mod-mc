package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class ElectricFurnanceBlockBlockDestroyedByPlayerProcedure extends MegaProjectModElements.ModElement {
	public ElectricFurnanceBlockBlockDestroyedByPlayerProcedure(MegaProjectModElements instance) {
		super(instance, 165);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ElectricFurnanceBlockBlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		MegaProjectModVariables.MapVariables
				.get(world).total_comsuption = (double) ((MegaProjectModVariables.MapVariables.get(world).total_comsuption) - 100);
		MegaProjectModVariables.MapVariables.get(world).syncData(world);
	}
}
