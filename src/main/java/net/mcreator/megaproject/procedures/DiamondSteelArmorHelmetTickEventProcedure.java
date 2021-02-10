package net.mcreator.megaproject.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorHelmetTickEventProcedure extends MegaProjectModElements.ModElement {
	public DiamondSteelArmorHelmetTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 227);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) > 1)
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_NightVision) == (true)))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 300, (int) 2, (false), (false)));
			if ((Math.random() < 0.1)) {
				{
					double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) - 1);
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) > 1)
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_WaterBreathe) == (true)))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 180, (int) 2, (false), (false)));
			if ((Math.random() < 0.1)) {
				{
					double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) - 1);
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
