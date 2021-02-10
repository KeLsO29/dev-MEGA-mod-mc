package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAplasmalabelProcedure extends MegaProjectModElements.ModElement {

	public DSAplasmalabelProcedure(MegaProjectModElements instance) {
		super(instance, 291);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAplasmalabel!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DiamondSteelArmorItem.body, (int) (1))
						.getItem()) == (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_PlasmaShoot) == (true)))) {
			return (true);
		}
		return (false);

	}

}
