
package net.mcreator.megaproject.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.megaproject.item.BuildertoolItem;
import net.mcreator.megaproject.MegaProjectModElements;

@MegaProjectModElements.ModElement.Tag
public class BuildrangeEnchantment extends MegaProjectModElements.ModElement {
	@ObjectHolder("mega_project:buildrange")
	public static final Enchantment enchantment = null;
	public BuildrangeEnchantment(MegaProjectModElements instance) {
		super(instance, 268);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("buildrange"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ALL, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 2;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(BuildertoolItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(BuildertoolItem.block, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
