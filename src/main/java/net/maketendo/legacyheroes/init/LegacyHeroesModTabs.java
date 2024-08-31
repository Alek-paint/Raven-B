
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.maketendo.legacyheroes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.maketendo.legacyheroes.LegacyHeroesMod;

public class LegacyHeroesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegacyHeroesMod.MODID);
	public static final RegistryObject<CreativeModeTab> LEGACY_HEROES = REGISTRY.register("legacy_heroes",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.legacy_heroes.legacy_heroes")).icon(() -> new ItemStack(LegacyHeroesModItems.HEROCOSTUMESUITCASE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LegacyHeroesModItems.HEROCOSTUMESUITCASE.get());
			}).withSearchBar().build());
}
