package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class UnlockallrecipescommandCommandExecutedProcedure extends MegaProjectModElements.ModElement {

	public UnlockallrecipescommandCommandExecutedProcedure(MegaProjectModElements instance) {
		super(instance, 91);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure UnlockallrecipescommandCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("mega_project:@registryname"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}

	}

}
