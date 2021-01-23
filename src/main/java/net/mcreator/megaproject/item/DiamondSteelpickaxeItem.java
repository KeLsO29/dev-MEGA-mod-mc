
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelpickaxeItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:diamond_steelpickaxe")
	public static final Item block = null;

	public DiamondSteelpickaxeItem(MegaProjectModElements instance) {
		super(instance, 109);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 115000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("diamond_steelpickaxe"));
	}

}