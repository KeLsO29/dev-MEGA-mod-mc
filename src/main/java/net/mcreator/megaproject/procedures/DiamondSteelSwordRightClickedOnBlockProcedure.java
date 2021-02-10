package net.mcreator.megaproject.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModElements;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

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
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DiamondSteelSwordRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("ThorPower")) == (true))) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (((entityiterator instanceof LivingEntity) && ((!(entityiterator instanceof ArmorStandEntity))
							&& ((!(entityiterator instanceof PlayerEntity)) || (!(entityiterator instanceof ServerPlayerEntity)))))) {
						if (world instanceof ServerWorld)
							((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) (entityiterator.getPosX()),
									(int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()), false));
						{
							ItemStack _ist = (itemstack);
							if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
						entityiterator.attackEntityFrom(DamageSource.MAGIC, (float) 5);
					}
				}
			}
		}
	}
}
