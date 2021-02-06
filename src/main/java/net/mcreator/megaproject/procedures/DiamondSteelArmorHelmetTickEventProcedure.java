package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorHelmetTickEventProcedure extends MegaProjectModElements.ModElement {

	public DiamondSteelArmorHelmetTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 227);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorHelmetTickEvent!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,(int) 180,(int) 1, (false), (false)));}

	}

}
