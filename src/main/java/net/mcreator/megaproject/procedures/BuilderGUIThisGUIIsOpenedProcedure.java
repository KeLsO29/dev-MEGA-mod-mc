package net.mcreator.megaproject.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.function.Supplier;
import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class BuilderGUIThisGUIIsOpenedProcedure extends MegaProjectModElements.ModElement {
	public BuilderGUIThisGUIIsOpenedProcedure(MegaProjectModElements instance) {
		super(instance, 257);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BuilderGUIThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((0 < (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0))))) {
			{
				ItemStack _setval = (new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (0)));
				entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.buildgun_material = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
