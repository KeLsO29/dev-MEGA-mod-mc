package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class TreechopperclickedProcedure extends MegaProjectModElements.ModElement {

	public TreechopperclickedProcedure(MegaProjectModElements instance) {
		super(instance, 189);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Treechopperclicked!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getBoolean("TreeChopper")) == (true))) {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putBoolean("TreeChopper", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Tree Chopper Deactivated!"), (true));
			}
		} else {
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putBoolean("TreeChopper", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Tree Chopper Activated!"), (true));
			}
		}

	}

}
