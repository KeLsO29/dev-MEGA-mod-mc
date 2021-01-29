
package net.mcreator.megaproject.block;

import net.minecraft.block.material.Material;

@MegaProjectModElements.ModElement.Tag
public class HeavyironblockBlock extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:heavyironblock")
	public static final Block block = null;

	public HeavyironblockBlock(MegaProjectModElements instance) {
		super(instance, 181);

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

					Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).hardnessAndResistance(50f, 50f).lightValue(0));

			setRegistryName("heavyironblock");
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
