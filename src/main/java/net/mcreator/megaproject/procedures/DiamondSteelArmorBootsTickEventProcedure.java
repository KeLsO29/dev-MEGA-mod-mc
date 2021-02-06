package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorBootsTickEventProcedure extends MegaProjectModElements.ModElement {

	public DiamondSteelArmorBootsTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 228);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorBootsTickEvent!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SPEED,(int) 60,(int) 3, (false), (false)));}

	}

}
