package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSASpeedonlcickProcedure extends MegaProjectModElements.ModElement {

	public DSASpeedonlcickProcedure(MegaProjectModElements instance) {
		super(instance, 225);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSASpeedonlcick!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Speed OFF"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Speed ON"), (true));
}}

	}

}
