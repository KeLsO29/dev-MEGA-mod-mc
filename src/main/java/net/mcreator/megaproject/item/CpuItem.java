
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class CpuItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:cpu")
	public static final Item block = null;

	public CpuItem(MegaProjectModElements instance) {
		super(instance, 251);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ProjectMEGAItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("cpu");
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
