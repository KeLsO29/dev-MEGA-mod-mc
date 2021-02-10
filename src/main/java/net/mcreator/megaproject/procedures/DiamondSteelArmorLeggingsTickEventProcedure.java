package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorLeggingsTickEventProcedure extends MegaProjectModElements.ModElement {

	public DiamondSteelArmorLeggingsTickEventProcedure(MegaProjectModElements instance) {
		super(instance, 274);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelArmorLeggingsTickEvent!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if (((>1)&&(==(true)))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING,(int) 60,(int) 1, (false), (false)));if ((Math.random()<0.1)) {}}if (((>1)&&(==(true)))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE,(int) 60,(int) 3, (false), (false)));if ((Math.random()<0.1)) {}}

	}

}
