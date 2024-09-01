
package net.maketendo.legacyheroes.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.maketendo.legacyheroes.procedures.ZeroGravityOverlayDisplayProcedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown9Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown8Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown7Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown6Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown5Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown4Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown3Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown2Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown1Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown10Procedure;
import net.maketendo.legacyheroes.procedures.QuirkCooldown0Procedure;
import net.maketendo.legacyheroes.procedures.InvisibilityOverlayDisplayProcedure;
import net.maketendo.legacyheroes.procedures.DisplaySelectedAttackSlot4Procedure;
import net.maketendo.legacyheroes.procedures.DisplaySelectedAttackSlot3Procedure;
import net.maketendo.legacyheroes.procedures.DisplaySelectedAttackSlot2Procedure;
import net.maketendo.legacyheroes.procedures.DisplaySelectedAttackSlot1Procedure;
import net.maketendo.legacyheroes.procedures.DisplayQuirkGuiProcedure;
import net.maketendo.legacyheroes.procedures.AttackNameDisplayProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class QuirkOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (DisplayQuirkGuiProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar.png"), w / 2 + 7, h / 2 + -6, 0, 0, 4, 13, 4, 13);

			if (QuirkCooldown1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 5, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 4, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 3, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 2, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 1, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + 0, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + -1, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + -2, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + -3, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + -4, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/energy_bar_progression.png"), w / 2 + 8, h / 2 + -5, 0, 0, 2, 1, 2, 1);
			}
			if (QuirkCooldown0Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/unable_icon.png"), w / 2 + 5, h / 2 + -3, 0, 0, 8, 7, 8, 7);
			}
			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_percentage_barr.png"), 3, 2, 0, 0, 182, 5, 182, 5);

			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_display_background.png"), 1, 6, 0, 0, 32, 32, 32, 32);

			if (InvisibilityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/invisibility_quirk_icon.png"), 8, 13, 0, 0, 18, 18, 18, 18);
			}
			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background.png"), 28, 4, 0, 0, 32, 32, 32, 32);

			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background.png"), 53, 4, 0, 0, 32, 32, 32, 32);

			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background.png"), 78, 4, 0, 0, 32, 32, 32, 32);

			event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background.png"), 103, 4, 0, 0, 32, 32, 32, 32);

			if (DisplaySelectedAttackSlot3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background_selected.png"), 78, 4, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySelectedAttackSlot4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background_selected.png"), 103, 4, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySelectedAttackSlot1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background_selected.png"), 28, 4, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySelectedAttackSlot2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/quirk_power_display_background_selected.png"), 53, 4, 0, 0, 32, 32, 32, 32);
			}
			if (InvisibilityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/blindness_attack.png"), 36, 12, 0, 0, 16, 16, 16, 16);
			}
			if (InvisibilityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/invisible_entity_attack.png"), 61, 12, 0, 0, 16, 16, 16, 16);
			}
			if (ZeroGravityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/skill_releace_attack_icon.png"), 60, 11, 0, 0, 18, 18, 18, 18);
			}
			if (ZeroGravityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/levitate_attack_icon.png"), 35, 11, 0, 0, 18, 18, 18, 18);
			}
			if (ZeroGravityOverlayDisplayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("legacy_heroes:textures/screens/zero_gravity_quirk_icon.png"), 8, 13, 0, 0, 18, 18, 18, 18);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.legacy_heroes.quirk_overlay.label_100"), 186, 2, -13369600, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.legacy_heroes.quirk_overlay.label_empty"), 204, 2, -13369600, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					AttackNameDisplayProcedure.execute(entity), 3, 37, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
