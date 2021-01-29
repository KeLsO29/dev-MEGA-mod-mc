package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class AutoFilterbuttonProcedure extends MegaProjectModElements.ModElement {

	public AutoFilterbuttonProcedure(MegaProjectModElements instance) {
		super(instance, 152);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AutoFilterbutton!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(false))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Auto Filter ON!"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Auto Filter OFF!"), (true));
}}

	}

}
