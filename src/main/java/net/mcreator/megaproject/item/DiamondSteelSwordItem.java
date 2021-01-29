
package net.mcreator.megaproject.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.megaproject.procedures.DiamondSteelSwordRightClickedOnBlockProcedure;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;
import java.util.HashMap;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelSwordItem extends MegaProjectModElements.ModElement {
	@ObjectHolder("mega_project:diamond_steel_sword")
	public static final Item block = null;
	public DiamondSteelSwordItem(MegaProjectModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 75000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, 0f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DiamondSteelSwordRightClickedOnBlockProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("diamond_steel_sword"));
	}
}
