package net.mcreator.megaproject.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.megaproject.block.Position2blockBlock;
import net.mcreator.megaproject.block.Position1blockBlock;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class GivememarkersbuttonProcedure extends MegaProjectModElements.ModElement {
	public GivememarkersbuttonProcedure(MegaProjectModElements instance) {
		super(instance, 269);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Givememarkersbutton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Position1blockBlock.block, (int) (1)))
				: false))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Position1blockBlock.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Pos 1 Marker in inventory"), (false));
			}
		}
		if ((!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Position2blockBlock.block, (int) (1)))
				: false))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Position2blockBlock.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Pos 2 Marker in inventory"), (false));
			}
		}
	}
}
