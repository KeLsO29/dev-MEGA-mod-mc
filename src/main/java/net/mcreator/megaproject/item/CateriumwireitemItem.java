
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class CateriumwireitemItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:cateriumwireitem")
	public static final Item block = null;

	public CateriumwireitemItem(MegaProjectModElements instance) {
		super(instance, 197);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("cateriumwireitem");
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
