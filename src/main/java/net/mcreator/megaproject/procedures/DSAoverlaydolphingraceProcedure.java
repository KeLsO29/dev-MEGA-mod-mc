package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAoverlaydolphingraceProcedure extends MegaProjectModElements.ModElement {

	public DSAoverlaydolphingraceProcedure(MegaProjectModElements instance) {
		super(instance, 284);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAoverlaydolphingrace!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DiamondSteelArmorItem.legs, (int) (1)).getItem())
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_DolphinGrace) == (true)))) {
			return (true);
		}
		return (false);

	}

}
