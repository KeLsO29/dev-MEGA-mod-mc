
package net.mcreator.megaproject.enchantment;

@MegaProjectModElements.ModElement.Tag
public class BetterCoolDownEnchantmentEnchantment extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:better_cool_down_enchantment")
	public static final Enchantment enchantment = null;

	public BetterCoolDownEnchantmentEnchantment(MegaProjectModElements instance) {
		super(instance, 298);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("better_cool_down_enchantment"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(DiamondSteelArmorItem.body, (int) (1)).getItem())
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
