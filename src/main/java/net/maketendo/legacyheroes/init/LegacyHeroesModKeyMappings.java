
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.maketendo.legacyheroes.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.maketendo.legacyheroes.network.UseQuirkPowerMessage;
import net.maketendo.legacyheroes.network.CycleAttacksRightMessage;
import net.maketendo.legacyheroes.network.CycleAttacksLeftMessage;
import net.maketendo.legacyheroes.LegacyHeroesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LegacyHeroesModKeyMappings {
	public static final KeyMapping USE_QUIRK_POWER = new KeyMapping("key.legacy_heroes.use_quirk_power", GLFW.GLFW_KEY_R, "key.categories.quirks") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LegacyHeroesMod.PACKET_HANDLER.sendToServer(new UseQuirkPowerMessage(0, 0));
				UseQuirkPowerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CYCLE_ATTACKS_LEFT = new KeyMapping("key.legacy_heroes.cycle_attacks_left", GLFW.GLFW_KEY_LEFT, "key.categories.quirks") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LegacyHeroesMod.PACKET_HANDLER.sendToServer(new CycleAttacksLeftMessage(0, 0));
				CycleAttacksLeftMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CYCLE_ATTACKS_RIGHT = new KeyMapping("key.legacy_heroes.cycle_attacks_right", GLFW.GLFW_KEY_RIGHT, "key.categories.quirks") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LegacyHeroesMod.PACKET_HANDLER.sendToServer(new CycleAttacksRightMessage(0, 0));
				CycleAttacksRightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(USE_QUIRK_POWER);
		event.register(CYCLE_ATTACKS_LEFT);
		event.register(CYCLE_ATTACKS_RIGHT);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				USE_QUIRK_POWER.consumeClick();
				CYCLE_ATTACKS_LEFT.consumeClick();
				CYCLE_ATTACKS_RIGHT.consumeClick();
			}
		}
	}
}
