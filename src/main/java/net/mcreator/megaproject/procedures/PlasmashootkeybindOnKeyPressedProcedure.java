package net.mcreator.megaproject.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.megaproject.item.PlasmaShootrangeditemItem;
import net.mcreator.megaproject.item.DiamondSteelArmorItem;
import net.mcreator.megaproject.enchantment.CheapPlasmaEnchantment;
import net.mcreator.megaproject.enchantment.BetterCoolDownEnchantmentEnchantment;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Random;
import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class PlasmashootkeybindOnKeyPressedProcedure extends MegaProjectModElements.ModElement {
	public PlasmashootkeybindOnKeyPressedProcedure(MegaProjectModElements instance) {
		super(instance, 292);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlasmashootkeybindOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlasmashootkeybindOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_PlasmaShoot_Cooldown) == 0)
				&& (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)
						.getItem() == new ItemStack(DiamondSteelArmorItem.body, (int) (1)).getItem())
						&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_PlasmaShoot) == (true)))
						&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) > 300)))) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				PlasmaShootrangeditemItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 5, (float) 5, (int) 5);
			}
			if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 0)) {
				{
					double _setval = (double) 200;
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 1)) {
				{
					double _setval = (double) 150;
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 2)) {
				{
					double _setval = (double) 110;
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 3)) {
				{
					double _setval = (double) 85;
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_PlasmaShoot_Cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 0)) {
				{
					double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) - 300);
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 1)) {
				{
					double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) - 220);
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY))) == 2)) {
				{
					double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) - 150);
					entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DSA_energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
