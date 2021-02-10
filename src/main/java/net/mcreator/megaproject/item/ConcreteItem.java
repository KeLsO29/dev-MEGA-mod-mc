
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class ConcreteItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:concrete")
	public static final Item block = null;

	public ConcreteItem(MegaProjectModElements instance) {
		super(instance, 241);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("concrete");
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
