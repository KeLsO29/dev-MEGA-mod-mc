
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelSwordItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:diamond_steel_sword")
	public static final Item block = null;

	public DiamondSteelSwordItem(MegaProjectModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 75000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("diamond_steel_sword"));
	}

}
