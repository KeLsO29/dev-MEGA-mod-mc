
package net.mcreator.megaproject.block;

import net.minecraft.block.material.Material;

@MegaProjectModElements.ModElement.Tag
public class SolarpanelblockinactiveBlock extends MegaProjectModElements.ModElement {

	@ObjectHolder("mega_project:solarpanelblockinactive")
	public static final Block block = null;

	public SolarpanelblockinactiveBlock(MegaProjectModElements instance) {
		super(instance, 201);

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

					Block.Properties.create(Material.IRON).sound(SoundType.GLASS).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("solarpanelblockinactive");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SolarpanelblockinactiveBlock.block, (int) (1)));
		}

		@Override
		public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(state, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				SolarpanelblockinactiveUpdateTickProcedure.executeProcedure($_dependencies);
			}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
		}

		@Override
		public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack itemstack) {
			super.onBlockPlacedBy(world, pos, state, entity, itemstack);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				SolarpanelblockinactiveBlockIsPlacedByProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
