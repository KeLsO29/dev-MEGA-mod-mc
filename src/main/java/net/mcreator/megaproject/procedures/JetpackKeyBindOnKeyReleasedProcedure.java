package net.mcreator.megaproject.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.item.DiamondSteelArmorItem;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class JetpackKeyBindOnKeyReleasedProcedure extends MegaProjectModElements.ModElement {
	public JetpackKeyBindOnKeyReleasedProcedure(MegaProjectModElements instance) {
		super(instance, 231);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JetpackKeyBindOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new ItemStack(DiamondSteelArmorItem.body, (int) (1))
				.getItem() == ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)
						.getItem())) {
			entity.getPersistentData().putBoolean("Jetpack", (false));
		}
	}
}
