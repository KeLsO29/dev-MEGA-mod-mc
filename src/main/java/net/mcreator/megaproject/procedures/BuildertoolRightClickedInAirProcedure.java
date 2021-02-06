package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class BuildertoolRightClickedInAirProcedure extends MegaProjectModElements.ModElement {

	public BuildertoolRightClickedInAirProcedure(MegaProjectModElements instance) {
		super(instance, 264);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BuildertoolRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BuildertoolRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BuildertoolRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BuildertoolRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BuildertoolRightClickedInAir!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		double result = 0;
		double a = 0;
		double b = 0;
		double c = 0;
		a = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new java.text.DecimalFormat("##").format(Math.abs((Math.abs() - Math.abs())))));
		b = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new java.text.DecimalFormat("##").format(Math.abs((Math.abs() - Math.abs())))));
		c = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new java.text.DecimalFormat("##").format(Math.abs((Math.abs() - Math.abs())))));
		if ((Math.round((a)) == 0)) {
			a = (double) 1;
		}
		if ((Math.round((b)) == 0)) {
			b = (double) 1;
		}
		if ((Math.round((c)) == 0)) {
			c = (double) 1;
		}
		result = (double) (((a) * (b)) * (c));
		if ((((EnchantmentHelper.getEnchantmentLevel(BuildrangeEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 0) && ((result) <= 64))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						(("fill ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ("mega_project:builder_previewblock") + "" + (" replace air")));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Preview Activated! You can Clear it in build gun menu."))),
						(false));
			}
		}
		if ((((EnchantmentHelper.getEnchantmentLevel(BuildrangeEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1) && ((result) <= 90))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						(("fill ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ("mega_project:builder_previewblock") + "" + (" replace air")));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Preview Activated! You can Clear it in build gun menu."))),
						(false));
			}
		}
		if ((((EnchantmentHelper.getEnchantmentLevel(BuildrangeEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2) && ((result) <= 128))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						(("fill ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ((new java.text.DecimalFormat("##").format())) + "" + (" ") + ""
								+ ((new java.text.DecimalFormat("##").format())) + "" + (" ") + "" + ((new java.text.DecimalFormat("##").format()))
								+ "" + (" ") + "" + ("mega_project:builder_previewblock") + "" + (" replace air")));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Preview Activated! You can Clear it in build gun menu."))),
						(false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Cant Show Preview. Too many blocks selected."))), (false));
			}
		}

	}

}
