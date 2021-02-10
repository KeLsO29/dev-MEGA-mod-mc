package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAoverlaywaterbreatheProcedure extends MegaProjectModElements.ModElement {

	public DSAoverlaywaterbreatheProcedure(MegaProjectModElements instance) {
		super(instance, 286);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAoverlaywaterbreathe!");
			return false;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.armorInventory.get((int) 3):ItemStack.EMPTY).getItem() == new ItemStack(DiamondSteelArmorItem.helmet, (int)(1)).getItem())&&(==(true)))) {return (true);}return (false);

	}

}
