
package net.mcreator.megaproject.item;

@MegaProjectModElements.ModElement.Tag
public class PermadayupgradeItem extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:permadayupgrade")
	public static final Item block = null;

	public PermadayupgradeItem(MegaProjectModElements instance) {
		super(instance, 215);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("permadayupgrade");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Upgrade for Perma Day  Place in HUB"));
		}

	}

}
