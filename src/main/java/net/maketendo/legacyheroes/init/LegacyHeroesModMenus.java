
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.maketendo.legacyheroes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.maketendo.legacyheroes.world.inventory.HeroCostumeSuitcaseGUIMenu;
import net.maketendo.legacyheroes.LegacyHeroesMod;

public class LegacyHeroesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LegacyHeroesMod.MODID);
	public static final RegistryObject<MenuType<HeroCostumeSuitcaseGUIMenu>> HERO_COSTUME_SUITCASE_GUI = REGISTRY.register("hero_costume_suitcase_gui", () -> IForgeMenuType.create(HeroCostumeSuitcaseGUIMenu::new));
}
