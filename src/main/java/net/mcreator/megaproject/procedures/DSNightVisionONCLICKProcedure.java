package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSNightVisionONCLICKProcedure extends MegaProjectModElements.ModElement {

	public DSNightVisionONCLICKProcedure(MegaProjectModElements instance) {
		super(instance, 224);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSNightVisionONCLICK!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Night Vision OFF"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Night Vision ON"), (true));
}}

	}

}
