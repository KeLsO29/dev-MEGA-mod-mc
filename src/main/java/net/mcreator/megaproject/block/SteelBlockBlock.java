
package net.mcreator.megaproject.block;

import net.minecraft.block.material.Material;

@MegaProjectModElements.ModElement.Tag
public class SteelBlockBlock extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:steel_block")
	public static final Block block = null;

	public SteelBlockBlock(MegaProjectModElements instance) {
		super(instance, 88);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.ANVIL).hardnessAndResistance(50f, 25f).lightValue(0));

			setRegistryName("steel_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
