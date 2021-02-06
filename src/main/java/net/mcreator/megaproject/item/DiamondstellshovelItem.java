
package net.mcreator.megaproject.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.megaproject.itemgroup.ProjectMEGAItemGroup;
import net.mcreator.megaproject.MegaProjectModElements;

@MegaProjectModElements.ModElement.Tag
public class DiamondstellshovelItem extends MegaProjectModElements.ModElement {
	@ObjectHolder("mega_project:diamondstellshovel")
	public static final Item block = null;
	public DiamondstellshovelItem(MegaProjectModElements instance) {
		super(instance, 118);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 115144;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2f, new Item.Properties().group(ProjectMEGAItemGroup.tab)) {
		}.setRegistryName("diamondstellshovel"));
	}
}
