
package net.mcreator.megaproject.block;

import net.minecraft.block.material.Material;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelblockBlock extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:diamond_steelblock")
	public static final Block block = null;

	public DiamondSteelblockBlock(MegaProjectModElements instance) {
		super(instance, 94);

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

					Block.Properties.create(Material.ANVIL).sound(SoundType.METAL).hardnessAndResistance(55f, 25f).lightValue(0));

			setRegistryName("diamond_steelblock");
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
