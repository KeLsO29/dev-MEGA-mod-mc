package net.mcreator.megaproject.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.server.MinecraftServer;

import net.mcreator.megaproject.block.IronOreNodeBlockBlock;
import net.mcreator.megaproject.MegaProjectModElements;

import java.util.Map;

@MegaProjectModElements.ModElement.Tag
public class NodeScannerRightClickedOnBlockProcedure extends MegaProjectModElements.ModElement {
	public NodeScannerRightClickedOnBlockProcedure(MegaProjectModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure NodeScannerRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-25);
		found = (boolean) (false);
		for (int index0 = 0; index0 < (int) (50); index0++) {
			sy = (double) (-25);
			for (int index1 = 0; index1 < (int) (50); index1++) {
				sz = (double) (-25);
				for (int index2 = 0; index2 < (int) (50); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
							.getBlock() == IronOreNodeBlockBlock.block.getDefaultState().getBlock())) {
						{
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().sendMessage(new StringTextComponent((((new Object() {
									public String getValue(BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getString(tag);
										return "";
									}
								}.getValue(new BlockPos((int) x, (int) y, (int) z), "NodeMaterial"))) + "" + (" Node Found On:") + "" + ("X:") + ""
										+ ((x + (sx))) + "" + ("Y:") + "" + ((y + (sy))) + "" + ("Z:") + "" + ((z + (sz))))));
						}
						found = (boolean) (true);
					}
					sz = (double) ((sz) + 1);
				}
				sy = (double) ((sy) + 1);
			}
			sx = (double) ((sx) + 1);
		}
		if (((found) == (false))) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("No Nodes Around"));
			}
		}
	}
}
