
package net.mcreator.megaproject.world.structure;

@MegaProjectModElements.ModElement.Tag
public class LimestonenodeStructure extends MegaProjectModElements.ModElement {

	public LimestonenodeStructure(MegaProjectModElements instance) {
		super(instance, 238);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig::deserialize) {
			@Override
			public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				int ci = (pos.getX() >> 4) << 4;
				int ck = (pos.getZ() >> 4) << 4;

				DimensionType dimensionType = world.getDimension().getType();
				boolean dimensionCriteria = false;

				if (dimensionType == DimensionType.OVERWORLD)
					dimensionCriteria = true;

				if (!dimensionCriteria)
					return false;

				if ((random.nextInt(1000000) + 1) <= 8500) {
					int count = random.nextInt(1) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16);
						int k = ck + random.nextInt(16);
						int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);

						j -= 1;

						BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
						boolean blockCriteria = false;
						if (blockAt.getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.SAND.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.SANDSTONE.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.STONE.getDefaultState().getBlock())
							blockCriteria = true;
						if (!blockCriteria)
							continue;

						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];

						BlockPos spawnTo = new BlockPos(i + 0, j + -2, k + 0);

						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();

						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("mega_project", "limestone_node_big"));

						if (template == null)
							return false;

						template.addBlocksToWorld(world, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
								.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false));

					}
				}

				return true;
			}
		};

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}

}
