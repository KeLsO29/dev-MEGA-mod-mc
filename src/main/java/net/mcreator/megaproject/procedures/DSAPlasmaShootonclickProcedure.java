package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DSAPlasmaShootonclickProcedure extends MegaProjectModElements.ModElement {

	public DSAPlasmaShootonclickProcedure(MegaProjectModElements instance) {
		super(instance, 290);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DSAPlasmaShootonclick!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Plasma Shoot OFF"), (true));
}}else{if(entity instanceof PlayerEntity && !entity.world.isRemote){
	((PlayerEntity)entity).sendStatusMessage(new StringTextComponent("Plasma Shoot ON"), (true));
}}

	}

}
