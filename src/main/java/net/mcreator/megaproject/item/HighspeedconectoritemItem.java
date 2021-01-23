
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class HighspeedconectoritemItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:highspeedconectoritem")
	public static final Item block = null;

	public HighspeedconectoritemItem(MegaProjectModElements instance) {
		super(instance, 102);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("highspeedconectoritem");
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