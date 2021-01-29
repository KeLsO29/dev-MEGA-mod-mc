
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class CateriumroditemItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:cateriumroditem")
	public static final Item block = null;

	public CateriumroditemItem(MegaProjectModElements instance) {
		super(instance, 196);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("cateriumroditem");
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
