package net.mcreator.megaproject.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorBootsTickEventProcedure extends MegaProjectModElements.ModElement {
	public DiamondSteelArmorBootsTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 228);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_Speed) == (true))
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) > 1))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60, (int) 3, (false), (false)));
			if ((Math.random() < 0.05)) {
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
