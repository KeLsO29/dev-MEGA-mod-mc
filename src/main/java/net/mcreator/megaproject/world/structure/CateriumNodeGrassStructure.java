
package net.mcreator.megaproject.world.structure;

@MegaProjectModElements.ModElement.Tag
public class CateriumNodeGrassStructure extends MegaProjectModElements.ModElement {

	public CateriumNodeGrassStructure(MegaProjectModElements instance) {
		super(instance, 28);
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

				if ((random.nextInt(1000000) + 1) <= 10000) {
					int count = random.nextInt(1) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16);
						int k = ck + random.nextInt(16);
						int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);

						j -= 1;

						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];

						BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);

						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();

						if (!

						CateriumNodeGrassAdditionalGenerationConditionProcedure
								.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
							continue;

						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("mega_project", "caterium_node_grass"));

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
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("plains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("desert")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("river")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("beach")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("wooded_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountain_edge")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("jungle")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("dark_forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("shattered_savanna")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("shattered_savanna_plateau")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}

}
