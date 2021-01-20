package net.mcreator.megaproject.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class NodeScannerRightClickedInAirProcedure extends MegaProjectModElements.ModElement {
	public NodeScannerRightClickedInAirProcedure(MegaProjectModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NodeScannerRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure NodeScannerRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((((itemstack).getOrCreateTag().getString("NodeMaterial"))).equals("Iron"))) {
			(itemstack).getOrCreateTag().putString("NodeMaterial", "Caterium");
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Scanning for Caterium"), (true));
			}
		} else if (((((itemstack).getOrCreateTag().getString("NodeMaterial"))).equals("Caterium"))) {
			(itemstack).getOrCreateTag().putString("NodeMaterial", "Iron");
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Scanning for Iron"), (true));
			}
		}
	}
}
