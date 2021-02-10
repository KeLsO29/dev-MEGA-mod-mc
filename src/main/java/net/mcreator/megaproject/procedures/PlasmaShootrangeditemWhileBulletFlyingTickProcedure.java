package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class PlasmaShootrangeditemWhileBulletFlyingTickProcedure extends MegaProjectModElements.ModElement {
	public PlasmaShootrangeditemWhileBulletFlyingTickProcedure(MegaProjectModElements instance) {
		super(instance, 295);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlasmaShootrangeditemWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlasmaShootrangeditemWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlasmaShootrangeditemWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlasmaShootrangeditemWhileBulletFlyingTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0.1, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0.1, 0, 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, (-0.1), 0);
		world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, (-0.1));
	}
}
