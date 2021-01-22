package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class NodeScannerModesKeybindOnKeyPressedProcedure extends MegaProjectModElements.ModElement {

	public NodeScannerModesKeybindOnKeyPressedProcedure(MegaProjectModElements instance) {
		super(instance, 42);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NodeScannerModesKeybindOnKeyPressed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(NodeScannerItem.block, (int) (1)).getItem())) {
			if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("NodeMaterial"))).equals("Iron"))) {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("NodeMaterial", "Caterium");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Now Scanning for Caterium"), (true));
				}
			} else if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("NodeMaterial"))).equals("Caterium"))) {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("NodeMaterial", "Coal");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Now Scanning for Coal"), (true));
				}
			} else if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.getString("NodeMaterial"))).equals("Coal"))) {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("NodeMaterial", "Iron");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Now Scanning for Iron"), (true));
				}
			} else {
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putString("NodeMaterial", "Iron");
			}
		}

	}

}
