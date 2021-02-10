package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.megaproject.block.BuilderPreviewblockBlock;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class BuilderclearprocedureProcedure extends MegaProjectModElements.ModElement {
	public BuilderclearprocedureProcedure(MegaProjectModElements instance) {
		super(instance, 266);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Builderclearprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Builderclearprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Builderclearprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Builderclearprocedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Builderclearprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-150);
		for (int index0 = 0; index0 < (int) (300); index0++) {
			sy = (double) (-30);
			for (int index1 = 0; index1 < (int) (80); index1++) {
				sz = (double) (-150);
				for (int index2 = 0; index2 < (int) (300); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
							.getBlock() == BuilderPreviewblockBlock.block.getDefaultState().getBlock())) {
						world.setBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), Blocks.AIR.getDefaultState(), 3);
					}
					sz = (double) ((sz) + 1);
				}
				sy = (double) ((sy) + 1);
			}
			sx = (double) ((sx) + 1);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Preview Cleared."), (false));
		}
	}
}
