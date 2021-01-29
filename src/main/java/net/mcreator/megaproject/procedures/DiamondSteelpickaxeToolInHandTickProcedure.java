package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelpickaxeToolInHandTickProcedure extends MegaProjectModElements.ModElement {

	public DiamondSteelpickaxeToolInHandTickProcedure(MegaProjectModElements instance) {
		super(instance, 151);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DiamondSteelpickaxeToolInHandTick!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((==(true))) {if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(Blocks.COBBLESTONE, (int)(1))):false)) {if(entity instanceof PlayerEntity) {
	ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE, (int)(1));
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int)1);
}}else if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(Blocks.GRANITE, (int)(1))):false)) {if(entity instanceof PlayerEntity) {
	ItemStack _stktoremove = new ItemStack(Blocks.GRANITE, (int)(1));
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int)1);
}}else if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(Blocks.DIORITE, (int)(1))):false)) {if(entity instanceof PlayerEntity) {
	ItemStack _stktoremove = new ItemStack(Blocks.DIORITE, (int)(1));
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int)1);
}}else if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(Blocks.ANDESITE, (int)(1))):false)) {if(entity instanceof PlayerEntity) {
	ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE, (int)(1));
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int)1);
}}else if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(Blocks.GRAVEL, (int)(1))):false)) {if(entity instanceof PlayerEntity) {
	ItemStack _stktoremove = new ItemStack(Blocks.GRAVEL, (int)(1));
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int)1);
}}}

	}

}
