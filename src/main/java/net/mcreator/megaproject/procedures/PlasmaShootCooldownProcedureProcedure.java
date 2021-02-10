package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class PlasmaShootCooldownProcedureProcedure extends MegaProjectModElements.ModElement {

	public PlasmaShootCooldownProcedureProcedure(MegaProjectModElements instance) {
		super(instance, 297);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies){


		if ((>0)) {}

	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

}
