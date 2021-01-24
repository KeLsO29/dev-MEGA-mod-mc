
package net.mcreator.megaproject.item;

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
		}, 1, -2f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("diamondstellshovel"));
	}

}
