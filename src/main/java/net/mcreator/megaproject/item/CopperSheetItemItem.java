
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class CopperSheetItemItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:copper_sheet_item")
	public static final Item block = null;

	public CopperSheetItemItem(MegaProjectModElements instance) {
		super(instance, 29);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copper_sheet_item");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
