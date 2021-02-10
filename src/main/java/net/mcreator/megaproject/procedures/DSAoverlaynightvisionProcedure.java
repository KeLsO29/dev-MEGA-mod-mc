package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAoverlaynightvisionProcedure extends MegaProjectModElements.ModElement {

	public DSAoverlaynightvisionProcedure(MegaProjectModElements instance) {
		super(instance, 283);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAoverlaynightvision!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DiamondSteelArmorItem.helmet, (int) (1)).getItem())
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_NightVision) == (true)))) {
			return (true);
		}
		return (false);

	}

}
