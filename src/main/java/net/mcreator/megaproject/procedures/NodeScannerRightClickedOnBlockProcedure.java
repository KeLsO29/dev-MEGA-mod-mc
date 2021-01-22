package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.block.IronOreNodeBlockBlock;
import net.mcreator.megaproject.block.CoalNodeBlock;
import net.mcreator.megaproject.block.CateriumNODEblockBlock;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class NodeScannerRightClickedOnBlockProcedure extends MegaProjectModElements.ModElement {
	public NodeScannerRightClickedOnBlockProcedure(MegaProjectModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((((itemstack).getOrCreateTag().getString("NodeMaterial"))).equals("Iron"))) {
			sx = (double) (-50);
			found = (boolean) (false);
			for (int index0 = 0; index0 < (int) (100); index0++) {
				sy = (double) (-50);
				for (int index1 = 0; index1 < (int) (100); index1++) {
					sz = (double) (-50);
					for (int index2 = 0; index2 < (int) (100); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == IronOreNodeBlockBlock.block.getDefaultState().getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((("Iron Node Found On:") + "" + ("  X:") + "" + (Math.round(((x + (sx)) + 1))) + ""
												+ ("  Y:") + "" + (Math.round((y + (sy)))) + "" + ("  Z:") + "" + (Math.round((z + (sz)))))),
										(false));
							}
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (false))) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No Nodes Around"), (false));
				}
			}
		} else if (((((itemstack).getOrCreateTag().getString("NodeMaterial"))).equals("Caterium"))) {
			sx = (double) (-50);
			found = (boolean) (false);
			for (int index3 = 0; index3 < (int) (100); index3++) {
				sy = (double) (-50);
				for (int index4 = 0; index4 < (int) (100); index4++) {
					sz = (double) (-50);
					for (int index5 = 0; index5 < (int) (100); index5++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == CateriumNODEblockBlock.block.getDefaultState().getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((("Caterium Node Found On:") + "" + ("  X:") + "" + (Math.round(((x + (sx)) + 1)))
												+ "" + ("  Y:") + "" + (Math.round((y + (sy)))) + "" + ("  Z:") + "" + (Math.round((z + (sz)))))),
										(false));
							}
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (false))) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No Nodes Around"), (false));
				}
			}
		} else if (((((itemstack).getOrCreateTag().getString("NodeMaterial"))).equals("Coal"))) {
			sx = (double) (-50);
			found = (boolean) (false);
			for (int index6 = 0; index6 < (int) (100); index6++) {
				sy = (double) (-50);
				for (int index7 = 0; index7 < (int) (100); index7++) {
					sz = (double) (-50);
					for (int index8 = 0; index8 < (int) (100); index8++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == CoalNodeBlock.block.getDefaultState().getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((("Coal Node Found On:") + "" + ("  X:") + "" + (Math.round(((x + (sx)) + 1))) + ""
												+ ("  Y:") + "" + (Math.round((y + (sy)))) + "" + ("  Z:") + "" + (Math.round((z + (sz)))))),
										(false));
							}
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (false))) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No Nodes Around"), (false));
				}
			}
		}
	}
}
