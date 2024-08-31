
package net.maketendo.legacyheroes.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.network.FriendlyByteBuf;

import net.maketendo.legacyheroes.LegacyHeroesMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UseQuirkPowerMessage {
	int type, pressedms;

	public UseQuirkPowerMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public UseQuirkPowerMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(UseQuirkPowerMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(UseQuirkPowerMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LegacyHeroesMod.addNetworkMessage(UseQuirkPowerMessage.class, UseQuirkPowerMessage::buffer, UseQuirkPowerMessage::new, UseQuirkPowerMessage::handler);
	}
}
