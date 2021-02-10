package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class EnergyplazmaEntityCollidesInTheBlockProcedure extends MegaProjectModElements.ModElement {

	public EnergyplazmaEntityCollidesInTheBlockProcedure(MegaProjectModElements instance) {
		super(instance, 288);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EnergyplazmaEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure EnergyplazmaEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure EnergyplazmaEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure EnergyplazmaEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EnergyplazmaEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(
				new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
						(int) (MegaProjectModVariables.MapVariables.get(world).hub_y), (int) (MegaProjectModVariables.MapVariables.get(world).hub_z)),
				"Energy")) > 100) == (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) < 15000))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
						(int) (MegaProjectModVariables.MapVariables.get(world).hub_y), (int) (MegaProjectModVariables.MapVariables.get(world).hub_z));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Energy", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (MegaProjectModVariables.MapVariables.get(world).hub_x),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_y),
							(int) (MegaProjectModVariables.MapVariables.get(world).hub_z)), "Energy")) - 50));

				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			{
				double _setval = (double) (((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) + 1);
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DSA_energy = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mega_project:plazma")),
						SoundCategory.NEUTRAL, (float) 0.01, (float) 0.01);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mega_project:plazma")),
						SoundCategory.NEUTRAL, (float) 0.01, (float) 0.01, false);
			}
			world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, 0);
			world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0.7, 0.5, 0);
			world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), (-0.7), 0.5, 0);
			world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, (-0.7));
			world.addParticle(ParticleTypes.ENCHANTED_HIT, (x + 0.5), y, (z + 0.5), 0, 0.5, 0.7);
		}

	}

}
