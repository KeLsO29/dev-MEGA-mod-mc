
package net.mcreator.megaproject.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.megaproject.procedures.DSNightVisionONCLICKProcedure;
import net.mcreator.megaproject.procedures.DSAslowfallingonclikProcedure;
import net.mcreator.megaproject.procedures.DSAplasmalabelProcedure;
import net.mcreator.megaproject.procedures.DSAoverlaywaterbreatheProcedure;
import net.mcreator.megaproject.procedures.DSAoverlayspeedProcedure;
import net.mcreator.megaproject.procedures.DSAoverlayslowfallingProcedure;
import net.mcreator.megaproject.procedures.DSAoverlaynightvisionProcedure;
import net.mcreator.megaproject.procedures.DSAoverlayjetpackProcedure;
import net.mcreator.megaproject.procedures.DSAoverlaydolphingraceProcedure;
import net.mcreator.megaproject.procedures.DSAdolphingraceonclickProcedure;
import net.mcreator.megaproject.procedures.DSAWaterBreatheonclickProcedure;
import net.mcreator.megaproject.procedures.DSASpeedonlcickProcedure;
import net.mcreator.megaproject.procedures.DSAPlasmaShootonclickProcedure;
import net.mcreator.megaproject.procedures.DSAJetpackonclicklProcedure;
import net.mcreator.megaproject.MegaProjectModVariables;
import net.mcreator.megaproject.MegaProjectModElements;
import net.mcreator.megaproject.MegaProjectMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@MegaProjectModElements.ModElement.Tag
public class DiamondSteelArmorGUIGui extends MegaProjectModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public DiamondSteelArmorGUIGui(MegaProjectModElements instance) {
		super(instance, 223);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("diamond_steel_armor_gui"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 248;
			this.ySize = 218;
		}
		private static final ResourceLocation texture = new ResourceLocation("mega_project:textures/diamond_steel_armor_gui.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mega_project:textures/2.png"));
			this.blit(this.guiLeft + 114, this.guiTop + 87, 0, 0, 16, 16, 16, 16);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mega_project:textures/1.png"));
			this.blit(this.guiLeft + 114, this.guiTop + 60, 0, 0, 16, 16, 16, 16);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mega_project:textures/3.png"));
			this.blit(this.guiLeft + 114, this.guiTop + 33, 0, 0, 16, 16, 16, 16);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("mega_project:textures/4.png"));
			this.blit(this.guiLeft + 114, this.guiTop + 114, 0, 0, 16, 16, 16, 16);
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("Armor Panel", 4, 4, -12829636);
			if (DSAoverlayspeedProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Speed", 166, 197, -16724992);
			if (DSAoverlayslowfallingProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Slow Falling", 149, 184, -13382656);
			if (DSAoverlayjetpackProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("JetPack", 160, 170, -16724992);
			if (DSAoverlaynightvisionProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Night Vision", 150, 156, -16724992);
			if (DSAoverlaywaterbreatheProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Water Breathe", 14, 157, -13382656);
			if (DSAoverlaydolphingraceProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Fast Swim", 22, 184, -16724992);
			this.font.drawString("Energy: " + (int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_energy) + "", 78, 3, -16750849);
			this.font.drawString("Active Functions", 80, 143, -12829636);
			if (DSAplasmalabelProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
				this.font.drawString("Plasma Shoot", 16, 170, -16724992);
			this.font.drawString("Plasma Shoot CoolDown: " + (int) ((entity.getCapability(MegaProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MegaProjectModVariables.PlayerVariables())).DSA_PlasmaShoot_Cooldown) + "", 4, 17, -12829636);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 150, this.guiTop + 33, 85, 20, "Night Vision", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(0, x, y, z));
				handleButtonAction(entity, 0, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 168, this.guiTop + 60, 60, 20, "Jetpack", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(1, x, y, z));
				handleButtonAction(entity, 1, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 168, this.guiTop + 114, 50, 20, "Speed", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(2, x, y, z));
				handleButtonAction(entity, 2, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 6, this.guiTop + 33, 90, 20, "Water Breathe", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(3, x, y, z));
				handleButtonAction(entity, 3, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 150, this.guiTop + 87, 85, 20, "Slow Falling", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(4, x, y, z));
				handleButtonAction(entity, 4, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 6, this.guiTop + 87, 90, 20, "Fast Swim", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(5, x, y, z));
				handleButtonAction(entity, 5, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 24, this.guiTop + 114, 30, 20, "X", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(6, x, y, z));
				handleButtonAction(entity, 6, x, y, z);
			}));
			this.addButton(new Button(this.guiLeft + 10, this.guiTop + 59, 85, 20, "Plasma Shoot", e -> {
				MegaProjectMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(7, x, y, z));
				handleButtonAction(entity, 7, x, y, z);
			}));
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSNightVisionONCLICKProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSAJetpackonclicklProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 2) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSASpeedonlcickProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 3) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSAWaterBreatheonclickProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 4) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSAslowfallingonclikProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 5) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSAdolphingraceonclickProcedure.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 7) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DSAPlasmaShootonclickProcedure.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
