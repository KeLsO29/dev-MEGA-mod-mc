package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAoverlayspeedProcedure extends MegaProjectModElements.ModElement {

	public DSAoverlayspeedProcedure(MegaProjectModElements instance) {
		super(instance, 281);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAoverlayspeed!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY)
				.getItem() == new ItemStack(DiamondSteelArmorItem.boots, (int) (1)).getItem())
				&& (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_Speed) == (true)))) {
			return (true);
		}
		return (false);

	}

}
