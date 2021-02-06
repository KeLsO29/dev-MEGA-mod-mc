
package net.mcreator.megaproject.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.procedures.DiamondSteelArmorHelmetTickEventProcedure;
import net.mcreator.megaproject.procedures.DiamondSteelArmorBootsTickEventProcedure;
import net.mcreator.megaproject.procedures.DiamondSteelArmorBodyTickEventProcedure;
import net.mcreator.megaproject.itemgroup.ProjectMEGAItemGroup;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;
import java.util.HashMap;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorItem extends MegaProjectModElements.ModElement {
	@ObjectHolder("mega_project:diamond_steel_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("mega_project:diamond_steel_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("mega_project:diamond_steel_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("mega_project:diamond_steel_armor_boots")
	public static final Item boots = null;
	public DiamondSteelArmorItem(MegaProjectModElements instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1024;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{15, 28, 23, 13}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 42;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DiamondsteelplateItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "diamond_steel_armor";
			}

			public float getToughness() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ProjectMEGAItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mega_project:textures/models/armor/diamondsteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DiamondSteelArmorHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("diamond_steel_armor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ProjectMEGAItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mega_project:textures/models/armor/diamondsteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DiamondSteelArmorBodyTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("diamond_steel_armor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ProjectMEGAItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mega_project:textures/models/armor/diamondsteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("diamond_steel_armor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ProjectMEGAItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mega_project:textures/models/armor/diamondsteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DiamondSteelArmorBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("diamond_steel_armor_boots"));
	}
}
