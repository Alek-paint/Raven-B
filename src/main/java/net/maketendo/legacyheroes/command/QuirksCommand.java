
package net.maketendo.legacyheroes.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.maketendo.legacyheroes.procedures.RemoveQuirkProcedure;
import net.maketendo.legacyheroes.procedures.AddInvisibilityQuirkProcedure;

@Mod.EventBusSubscriber
public class QuirksCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("quirk").requires(s -> s.hasPermission(3))
				.then(Commands.literal("give").then(Commands.argument("player", EntityArgument.player()).then(Commands.literal("random")).then(Commands.literal("invisibility").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AddInvisibilityQuirkProcedure.execute(arguments, entity);
					return 0;
				})).then(Commands.literal("hardening")).then(Commands.literal("zerogravity")).then(Commands.literal("hardening")).then(Commands.literal("hardening")).then(Commands.literal("hardening"))))
				.then(Commands.literal("remove").then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					RemoveQuirkProcedure.execute(arguments, entity);
					return 0;
				}))));
	}
}
