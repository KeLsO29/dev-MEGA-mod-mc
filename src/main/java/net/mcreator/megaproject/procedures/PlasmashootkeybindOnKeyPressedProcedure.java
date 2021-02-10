package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class PlasmashootkeybindOnKeyPressedProcedure extends MegaProjectModElements.ModElement {

	public PlasmashootkeybindOnKeyPressedProcedure(MegaProjectModElements instance) {
		super(instance, 292);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlasmashootkeybindOnKeyPressed!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlasmashootkeybindOnKeyPressed!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");
				IWorld world = (IWorld) dependencies.get("world");

		if (((==0)&&(((((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY).getItem() == new ItemStack(DiamondSteelArmorItem.body, (int)(1)).getItem())&&(==(true)))&&(>300)))) {if(world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity){
		PlasmaShootrangeditemItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 5, (float) 5, (int) 5);

}if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==0)) {}else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==1)) {}else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==2)) {}else if (((EnchantmentHelper.getEnchantmentLevel(BetterCoolDownEnchantmentEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==3)) {}if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==0)) {}else if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==1)) {}else if (((EnchantmentHelper.getEnchantmentLevel(CheapPlasmaEnchantment.enchantment, ((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 2):ItemStack.EMPTY)))==2)) {}}

	}

}
