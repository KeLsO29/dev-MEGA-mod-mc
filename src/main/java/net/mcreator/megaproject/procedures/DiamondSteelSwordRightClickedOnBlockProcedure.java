package net.mcreator.megaproject.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelSwordRightClickedOnBlockProcedure extends MegaProjectModElements.ModElement {
	public DiamondSteelSwordRightClickedOnBlockProcedure(MegaProjectModElements instance) {
		super(instance, 193);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("Throw")) == (true))) {
			if (((entity.getMotion().getX()) > 0)) {
				entity.setMotion(((entity.getMotion().getX()) + 5), 0, 0);
			}
			if (((entity.getMotion().getX()) < 0)) {
				entity.setMotion(((entity.getMotion().getX()) - 5), 0, 0);
			}
			if (((entity.getMotion().getZ()) > 0)) {
				entity.setMotion(0, 0, ((entity.getMotion().getZ()) + 5));
			}
			if (((entity.getMotion().getZ()) < 0)) {
				entity.setMotion(0, 0, ((entity.getMotion().getZ()) - 5));
			}
		}
	}
}
