package net.mcreator.megaproject;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class MegaProjectModVariables {
	public MegaProjectModVariables(MegaProjectModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "mega_project_worldvars";
		public ItemStack foundrymk1_igredience1 = ItemStack.EMPTY;
		public ItemStack foundrymk1_product = ItemStack.EMPTY;
		public ItemStack foundrymk1_igredience2 = ItemStack.EMPTY;
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			foundrymk1_igredience1 = ItemStack.read(nbt.getCompound("foundrymk1_igredience1"));
			foundrymk1_product = ItemStack.read(nbt.getCompound("foundrymk1_product"));
			foundrymk1_igredience2 = ItemStack.read(nbt.getCompound("foundrymk1_igredience2"));
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.put("foundrymk1_igredience1", foundrymk1_igredience1.write(new CompoundNBT()));
			nbt.put("foundrymk1_product", foundrymk1_product.write(new CompoundNBT()));
			nbt.put("foundrymk1_igredience2", foundrymk1_igredience2.write(new CompoundNBT()));
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (!world.getWorld().isRemote)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(world.getWorld().dimension::getType),
						new WorldSavedDataSyncMessage(1, this));
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(IWorld world) {
			if (world.getWorld() instanceof ServerWorld) {
				return ((ServerWorld) world.getWorld()).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "mega_project_mapvars";
		public double production = 0;
		public double hub_caterium_save = 0;
		public double hub_energy_save = 0;
		public double hub_z = 0;
		public double hub_x = 0;
		public double hub_y = 0;
		public double hub_copper_save = 0;
		public double total_production = 0;
		public double hub_oil_save = 0;
		public double total_comsuption = 0;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			production = nbt.getDouble("production");
			hub_caterium_save = nbt.getDouble("hub_caterium_save");
			hub_energy_save = nbt.getDouble("hub_energy_save");
			hub_z = nbt.getDouble("hub_z");
			hub_x = nbt.getDouble("hub_x");
			hub_y = nbt.getDouble("hub_y");
			hub_copper_save = nbt.getDouble("hub_copper_save");
			total_production = nbt.getDouble("total_production");
			hub_oil_save = nbt.getDouble("hub_oil_save");
			total_comsuption = nbt.getDouble("total_comsuption");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("production", production);
			nbt.putDouble("hub_caterium_save", hub_caterium_save);
			nbt.putDouble("hub_energy_save", hub_energy_save);
			nbt.putDouble("hub_z", hub_z);
			nbt.putDouble("hub_x", hub_x);
			nbt.putDouble("hub_y", hub_y);
			nbt.putDouble("hub_copper_save", hub_copper_save);
			nbt.putDouble("total_production", total_production);
			nbt.putDouble("hub_oil_save", hub_oil_save);
			nbt.putDouble("total_comsuption", total_comsuption);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (!world.getWorld().isRemote)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(IWorld world) {
			if (world.getWorld() instanceof ServerWorld) {
				return world.getWorld().getServer().getWorld(DimensionType.OVERWORLD).getSavedData().getOrCreate(MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("mega_project", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("placed_hub", instance.placed_hub);
			nbt.putDouble("player_back_y", instance.player_back_y);
			nbt.putDouble("player_home_z", instance.player_home_z);
			nbt.putDouble("player_back_x", instance.player_back_x);
			nbt.putDouble("player_home_y", instance.player_home_y);
			nbt.putDouble("player_home_x", instance.player_home_x);
			nbt.putDouble("player_back_z", instance.player_back_z);
			nbt.putDouble("hub_coal_save", instance.hub_coal_save);
			nbt.putDouble("hub_iron_save", instance.hub_iron_save);
			nbt.putDouble("player_rock_points", instance.player_rock_points);
			nbt.putDouble("player_minnig_level", instance.player_minnig_level);
			nbt.putBoolean("diamondsteel_itembuffer", instance.diamondsteel_itembuffer);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.placed_hub = nbt.getBoolean("placed_hub");
			instance.player_back_y = nbt.getDouble("player_back_y");
			instance.player_home_z = nbt.getDouble("player_home_z");
			instance.player_back_x = nbt.getDouble("player_back_x");
			instance.player_home_y = nbt.getDouble("player_home_y");
			instance.player_home_x = nbt.getDouble("player_home_x");
			instance.player_back_z = nbt.getDouble("player_back_z");
			instance.hub_coal_save = nbt.getDouble("hub_coal_save");
			instance.hub_iron_save = nbt.getDouble("hub_iron_save");
			instance.player_rock_points = nbt.getDouble("player_rock_points");
			instance.player_minnig_level = nbt.getDouble("player_minnig_level");
			instance.diamondsteel_itembuffer = nbt.getBoolean("diamondsteel_itembuffer");
		}
	}

	public static class PlayerVariables {
		public boolean placed_hub = false;
		public double player_back_y = 0;
		public double player_home_z = 0;
		public double player_back_x = 0;
		public double player_home_y = 0;
		public double player_home_x = 0;
		public double player_back_z = 0;
		public double hub_coal_save = 0;
		public double hub_iron_save = 0;
		public double player_rock_points = 0;
		public double player_minnig_level = 1.0;
		public boolean diamondsteel_itembuffer = false;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				MegaProjectMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.placed_hub = original.placed_hub;
		clone.player_back_y = original.player_back_y;
		clone.player_home_z = original.player_home_z;
		clone.player_back_x = original.player_back_x;
		clone.player_home_y = original.player_home_y;
		clone.player_home_x = original.player_home_x;
		clone.player_back_z = original.player_back_z;
		clone.hub_coal_save = original.hub_coal_save;
		clone.hub_iron_save = original.hub_iron_save;
		clone.player_rock_points = original.player_rock_points;
		clone.player_minnig_level = original.player_minnig_level;
		clone.diamondsteel_itembuffer = original.diamondsteel_itembuffer;
		if (!event.isWasDeath()) {
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.placed_hub = message.data.placed_hub;
					variables.player_back_y = message.data.player_back_y;
					variables.player_home_z = message.data.player_home_z;
					variables.player_back_x = message.data.player_back_x;
					variables.player_home_y = message.data.player_home_y;
					variables.player_home_x = message.data.player_home_x;
					variables.player_back_z = message.data.player_back_z;
					variables.hub_coal_save = message.data.hub_coal_save;
					variables.hub_iron_save = message.data.hub_iron_save;
					variables.player_rock_points = message.data.player_rock_points;
					variables.player_minnig_level = message.data.player_minnig_level;
					variables.diamondsteel_itembuffer = message.data.diamondsteel_itembuffer;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
