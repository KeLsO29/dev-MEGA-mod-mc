
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class DiamondsteelaxeItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:diamondsteelaxe")
	public static final Item block = null;

	public DiamondsteelaxeItem(MegaProjectModElements instance) {
		super(instance, 112);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 98000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 10f;
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
		}, 1, 1f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("diamondsteelaxe"));
	}

}
