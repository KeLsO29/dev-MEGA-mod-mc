
package net.mcreator.megaproject.fuel;

@MegaProjectModElements.ModElement.Tag
public class Turbofuelmk1Fuel extends MegaProjectModElements.ModElement {

	public Turbofuelmk1Fuel(MegaProjectModElements instance) {
		super(instance, 37);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(TurbofuelitemItem.block, (int) (1)).getItem())
			event.setBurnTime(9600);
	}

}
