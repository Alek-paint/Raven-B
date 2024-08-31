
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.maketendo.legacyheroes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.maketendo.legacyheroes.procedures.HerocostumesuitcasePropertyValueProviderProcedure;
import net.maketendo.legacyheroes.item.HerocostumesuitcaseItem;
import net.maketendo.legacyheroes.LegacyHeroesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LegacyHeroesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LegacyHeroesMod.MODID);
	public static final RegistryObject<Item> HEROCOSTUMESUITCASE = REGISTRY.register("herocostumesuitcase", () -> new HerocostumesuitcaseItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(HEROCOSTUMESUITCASE.get(), new ResourceLocation("legacy_heroes:herocostumesuitcase_rendersuitcasenumber"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) HerocostumesuitcasePropertyValueProviderProcedure.execute(entity));
		});
	}
}
