package net.mcreator.megaproject.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.item.DiamondSteelArmorItem;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DSAoverlayslowfallingProcedure extends MegaProjectModElements.ModElement {
	public DSAoverlayslowfallingProcedure(MegaProjectModElements instance) {
		super(instance, 282);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAoverlayslowfalling!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DiamondSteelArmorItem.legs, (int) (1)).getItem())
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_SlowFalling) == (true)))) {
			return (true);
		}
		return (false);
	}
}
