package net.maketendo.legacyheroes.procedures;

import net.minecraft.world.entity.Entity;

import net.maketendo.legacyheroes.network.LegacyHeroesModVariables;

public class AttackNameDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(LegacyHeroesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LegacyHeroesModVariables.PlayerVariables())).quirk_attack_selected;
	}
}
