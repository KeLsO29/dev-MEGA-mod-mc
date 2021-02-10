package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAdolphingraceonclickProcedure extends MegaProjectModElements.ModElement {

	public DSAdolphingraceonclickProcedure(MegaProjectModElements instance) {
		super(instance, 273);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAdolphingraceonclick!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Dolphin Grace OFF"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Dolphin Grace ON"), (true));
}}

	}

}
