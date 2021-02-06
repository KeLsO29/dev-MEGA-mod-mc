package net.mcreator.megaproject.procedures;

import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorBodyTickEventProcedure extends MegaProjectModElements.ModElement {
	public DiamondSteelArmorBodyTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 232);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPersistentData().getBoolean("Jetpack")) == (true))
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_Jetpack) == (true)))) {
			if (((entity.getHorizontalFacing()) == Direction.NORTH)) {
				entity.setMotion(((entity.getMotion().getX()) + 0), ((entity.getMotion().getY()) + 0.15), ((entity.getMotion().getZ()) - 0.15));
			} else if (((entity.getHorizontalFacing()) == Direction.SOUTH)) {
				entity.setMotion(((entity.getMotion().getX()) + 0), ((entity.getMotion().getY()) + 0.15), ((entity.getMotion().getZ()) + 0.15));
			} else if (((entity.getHorizontalFacing()) == Direction.WEST)) {
				entity.setMotion(((entity.getMotion().getX()) - 0.15), ((entity.getMotion().getY()) + 0.15), ((entity.getMotion().getZ()) + 0));
			} else if (((entity.getHorizontalFacing()) == Direction.EAST)) {
				entity.setMotion(((entity.getMotion().getX()) + 0.15), ((entity.getMotion().getY()) + 0.15), ((entity.getMotion().getZ()) + 0));
			} else {
				entity.setMotion(((entity.getMotion().getX()) + 0), ((entity.getMotion().getY()) + 0.15), ((entity.getMotion().getZ()) + 0));
			}
		}
	}
}
