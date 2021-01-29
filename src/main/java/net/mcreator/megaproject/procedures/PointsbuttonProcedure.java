package net.mcreator.megaproject.procedures;

@MegaProjectModElements.ModElement.Tag
public class PointsbuttonProcedure extends MegaProjectModElements.ModElement {

	public PointsbuttonProcedure(MegaProjectModElements instance) {
		super(instance, 153);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Pointsbutton!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if (((>=64)&&((new Object(){
	public int getAmount(int sltid) {
			if(entity instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) entity).openContainer;
				if(_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if(invobj instanceof Map) {
						ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
						if(stack != null)
							return stack.getCount();
					}
				}
			}
			return 0;
		}
		}.getAmount((int)(0)))==0))) {if(entity instanceof PlayerEntity) {
	Container _current = ((PlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE, (int)(1));
			_setstack.setCount((int) 64);
			((Slot) ((Map) invobj).get((int)(0))).putStack(_setstack);
			_current.detectAndSendChanges();
		}
	}
}}

	}

}
