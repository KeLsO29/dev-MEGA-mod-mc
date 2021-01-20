package net.mcreator.megaproject.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class AdminmenuDayNightProcedure extends MegaProjectModElements.ModElement {
	public AdminmenuDayNightProcedure(MegaProjectModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AdminmenuDayNight!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((12000 < (world.getWorld().getDayTime()))) {
			if (world instanceof World)
				world.getWorld().setDayTime((int) 0);
		} else if ((12000 > (world.getWorld().getDayTime()))) {
			if (world instanceof World)
				world.getWorld().setDayTime((int) 18000);
		}
	}
}
