package net.mcreator.megaproject.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class NodeScannerItemIsCraftedsmeltedProcedure extends MegaProjectModElements.ModElement {
	public NodeScannerItemIsCraftedsmeltedProcedure(MegaProjectModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure NodeScannerItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putString("NodeMaterial", "Iron");
	}
}
