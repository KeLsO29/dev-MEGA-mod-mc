
package net.mcreator.megaproject.enchantment;

@MegaProjectModElements.ModElement.Tag
public class CheapPlasmaEnchantment extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:cheap_plasma")
	public static final Enchantment enchantment = null;

	public CheapPlasmaEnchantment(MegaProjectModElements instance) {
		super(instance, 299);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("cheap_plasma"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_CHEST, slots);
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
