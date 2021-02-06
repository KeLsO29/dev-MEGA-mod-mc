package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAJetpackonclicklProcedure extends MegaProjectModElements.ModElement {

	public DSAJetpackonclicklProcedure(MegaProjectModElements instance) {
		super(instance, 226);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAJetpackonclickl!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Jetpack OFF"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Jetpack ON"), (true));
}}

	}

}
