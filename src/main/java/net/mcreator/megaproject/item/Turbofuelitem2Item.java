
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class Turbofuelitem2Item extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:turbofuelitem_2")
	public static final Item block = null;

	public Turbofuelitem2Item(MegaProjectModElements instance) {
		super(instance, 32);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("turbofuelitem_2");
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
