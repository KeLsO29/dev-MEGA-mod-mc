
package net.mcreator.megaproject.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.megaproject.item.Turbofuelitem3Item;
import net.mcreator.megaproject.MegaProjectModElements;

@MegaProjectModElements.ModElement.Tag
public class Turbofuelmk3Fuel extends MegaProjectModElements.ModElement {
	public Turbofuelmk3Fuel(MegaProjectModElements instance) {
		super(instance, 39);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(Turbofuelitem3Item.block, (int) (1)).getItem())
			event.setBurnTime(345600);
	}
}
