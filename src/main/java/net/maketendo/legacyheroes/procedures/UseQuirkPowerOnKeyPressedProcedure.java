package net.maketendo.legacyheroes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.maketendo.legacyheroes.network.LegacyHeroesModVariables;

public class UseQuirkPowerOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(LegacyHeroesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LegacyHeroesModVariables.PlayerVariables())).quirk).equals("invisibility")) {
			InvisibilityMoveSetsProcedure.execute(world, x, y, z, entity);
		} else if (((entity.getCapability(LegacyHeroesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LegacyHeroesModVariables.PlayerVariables())).quirk).equals("zero gravity")) {
			ZeroGravityMoveSetsProcedure.execute(world, x, y, z, entity);
		}
	}
}
