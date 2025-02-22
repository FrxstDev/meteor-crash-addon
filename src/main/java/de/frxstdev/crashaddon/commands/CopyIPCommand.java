package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.command.CommandSource;

public class CopyIPCommand extends Command {
    public CopyIPCommand() {
        super("copyip", "Copy IP from Server", "copy-ip", "ip");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ServerInfo info = mc.isInSingleplayer() ? null : mc.getCurrentServerEntry();
            MinecraftClient.getInstance().keyboard.setClipboard(info.address);
            return SINGLE_SUCCESS;
        });
    }

}
