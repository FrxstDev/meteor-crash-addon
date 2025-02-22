package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class CreditsCommand extends Command {
    public CreditsCommand() {
        super("credits", "Show credits of the Developer that coded this Addon", "dev", "drxem");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ChatUtils.sendMsg(Text.of("§7-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"));
            ChatUtils.sendMsg(Text.of("§6Addon: DrxemUtils"));
            ChatUtils.sendMsg(Text.of("§6YouTube: https://youtube.com/@Drxem"));
            ChatUtils.sendMsg(Text.of("§6GitHub: https://github.com/FrxstDev"));
            ChatUtils.sendMsg(Text.of("§6Discord: https://discord.gg/wnhvkk7XWU"));
            ChatUtils.sendMsg(Text.of("§7-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"));
            return SINGLE_SUCCESS;
        });
    }
}
