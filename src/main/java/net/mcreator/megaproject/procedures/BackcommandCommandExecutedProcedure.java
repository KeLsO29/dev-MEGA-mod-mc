package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class BackcommandCommandExecutedProcedure extends MegaProjectModElements.ModElement {

	public BackcommandCommandExecutedProcedure(MegaProjectModElements instance) {
		super(instance, 82);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BackcommandCommandExecuted!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		{
	Entity _ent = entity;
    _ent.setPositionAndUpdate(,,);
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation(, , , _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("You was returned to your previous location."), (false));
}

	}

}
