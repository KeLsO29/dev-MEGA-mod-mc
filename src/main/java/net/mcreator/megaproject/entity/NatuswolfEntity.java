
package net.mcreator.megaproject.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.megaproject.MegaProjectModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@MegaProjectModElements.ModElement.Tag
public class NatuswolfEntity extends MegaProjectModElements.ModElement {
	public static EntityType entity = null;
	public NatuswolfEntity(MegaProjectModElements instance) {
		super(instance, 279);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("natuswolf")
						.setRegistryName("natuswolf");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -10092544, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("natuswolf_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("mega_project:textures/natus_wolf.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 500;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, false, false));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1, true));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.growl"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(75);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(2D);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2D);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer body_rotation;
		private final ModelRenderer body_sub_1;
		private final ModelRenderer mane;
		private final ModelRenderer mane_rotation;
		private final ModelRenderer mane_sub_1;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		private final ModelRenderer tail;
		private final ModelRenderer head2;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(4.0F, 13.5F, -7.0F);
			head.setTextureOffset(0, 28).addBox(-4.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(0, 16).addBox(0.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(0, 13).addBox(-4.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(24, 13).addBox(-0.5F, 1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(24, 15).addBox(-2.5F, 1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(29, 0).addBox(-2.5F, -0.02F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(24, 13).addBox(-2.5F, 1.98F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(24, 15).addBox(-2.5F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(24, 13).addBox(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 14.0F, 2.0F);
			body_rotation = new ModelRenderer(this);
			body_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(body_rotation);
			setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);
			body_sub_1 = new ModelRenderer(this);
			body_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
			body_rotation.addChild(body_sub_1);
			body_sub_1.setTextureOffset(0, 13).addBox(-5.0F, -2.0F, -3.0F, 9.0F, 9.0F, 6.0F, 0.0F, false);
			mane = new ModelRenderer(this);
			mane.setRotationPoint(1.0F, 14.0F, 2.0F);
			mane_rotation = new ModelRenderer(this);
			mane_rotation.setRotationPoint(-1.0F, 2.5F, -2.5F);
			mane.addChild(mane_rotation);
			setRotationAngle(mane_rotation, 1.5708F, 0.0F, 0.0F);
			mane_sub_1 = new ModelRenderer(this);
			mane_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
			mane_rotation.addChild(mane_sub_1);
			mane_sub_1.setTextureOffset(0, 0).addBox(-6.0F, -5.5F, -0.5F, 11.0F, 6.0F, 7.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(2.5F, 16.0F, 7.0F);
			leg1.setTextureOffset(38, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-0.5F, 16.0F, 7.0F);
			leg2.setTextureOffset(8, 38).addBox(-4.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(2.5F, 16.0F, -4.0F);
			leg3.setTextureOffset(0, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-0.5F, 16.0F, -4.0F);
			leg4.setTextureOffset(36, 5).addBox(-4.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(1.0F, 12.0F, 10.0F);
			tail.setTextureOffset(30, 36).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 8.0F, 2.0F, 0.0F, false);
			tail.setTextureOffset(0, 0).addBox(-5.0F, 8.0F, 0.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			head2 = new ModelRenderer(this);
			head2.setRotationPoint(-3.0F, 13.5F, -7.0F);
			head2.setTextureOffset(16, 28).addBox(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(16, 28).addBox(-0.5F, 1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(0, 28).addBox(-2.5F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(0, 28).addBox(-2.5F, 1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(26, 26).addBox(-4.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
			head2.setTextureOffset(0, 3).addBox(0.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head2.setTextureOffset(16, 34).addBox(-2.5F, -0.02F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
			head2.setTextureOffset(30, 18).addBox(-2.5F, 1.98F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			mane.render(matrixStack, buffer, packedLight, packedOverlay);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
			head2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head2.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
