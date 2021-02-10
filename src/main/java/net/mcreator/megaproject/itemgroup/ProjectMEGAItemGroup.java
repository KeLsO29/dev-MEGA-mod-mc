
package net.mcreator.megaproject.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.megaproject.item.CircuitBoarditemItem;
import net.mcreator.megaproject.MegaProjectModElements;

@MegaProjectModElements.ModElement.Tag
public class ProjectMEGAItemGroup extends MegaProjectModElements.ModElement {
	public ProjectMEGAItemGroup(MegaProjectModElements instance) {
		super(instance, 218);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabproject_mega") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CircuitBoarditemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
