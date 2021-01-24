
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class AiLimiteritemItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:ai_limiteritem")
	public static final Item block = null;

	public AiLimiteritemItem(MegaProjectModElements instance) {
		super(instance, 118);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(32).rarity(Rarity.UNCOMMON));
			setRegistryName("ai_limiteritem");
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
