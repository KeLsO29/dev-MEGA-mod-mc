package net.mcreator.megaproject.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.megaproject.block.BuilderPreviewblockBlock;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Random;
import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class BuilderbuildprocedureProcedure extends MegaProjectModElements.ModElement {
	public BuilderbuildprocedureProcedure(MegaProjectModElements instance) {
		super(instance, 267);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Builderbuildprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Builderbuildprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Builderbuildprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Builderbuildprocedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Builderbuildprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage()) < 745)) {
			sx = (double) (-150);
			for (int index0 = 0; index0 < (int) (300); index0++) {
				sy = (double) (-20);
				for (int index1 = 0; index1 < (int) (70); index1++) {
					sz = (double) (-150);
					for (int index2 = 0; index2 < (int) (300); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == BuilderPreviewblockBlock.block.getDefaultState().getBlock())) {
							if (((entity instanceof PlayerEntity)
									? ((PlayerEntity) entity).inventory
											.hasItemStack(((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new MegaProjectModVariables.PlayerVariables())).buildgun_material))
									: false)) {
								world.setBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))),
										/* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock(((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new MegaProjectModVariables.PlayerVariables())).buildgun_material))),
										3);
								if (entity instanceof PlayerEntity) {
									ItemStack _stktoremove = ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MegaProjectModVariables.PlayerVariables())).buildgun_material);
									((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
								}
								if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getDamage()) < 745)) {
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Low Battery!"), (false));
									}
									break;
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No Enough Material In Inventory."), (false));
								}
								break;
							}
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Builded"), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Low Battery!"), (false));
			}
		}
	}
}
