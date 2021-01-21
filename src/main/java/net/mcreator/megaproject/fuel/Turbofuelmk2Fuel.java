
package net.mcreator.megaproject.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.megaproject.item.Turbofuelitem2Item;
import net.mcreator.megaproject.MegaProjectModElements;

@MegaProjectModElements.ModElement.Tag
public class Turbofuelmk2Fuel extends MegaProjectModElements.ModElement {
	public Turbofuelmk2Fuel(MegaProjectModElements instance) {
		super(instance, 38);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(Turbofuelitem2Item.block, (int) (1)).getItem())
			event.setBurnTime(57600);
	}
}
