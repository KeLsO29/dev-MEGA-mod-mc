
package net.mcreator.megaproject.block;

import net.minecraft.block.material.Material;

@MegaProjectModElements.ModElement.Tag
public class HeavyframeBlock extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:heavyframe")
	public static final Block block = null;

	public HeavyframeBlock(MegaProjectModElements instance) {
		super(instance, 208);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).hardnessAndResistance(20f, 10f).lightValue(0).notSolid());

			setRegistryName("heavyframe");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
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
