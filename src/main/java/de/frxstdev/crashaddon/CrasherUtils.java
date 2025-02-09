package de.frxstdev.crashaddon;

import de.frxstdev.crashaddon.commands.CrashItemCommand;
import de.frxstdev.crashaddon.hud.HudCredits;
import de.frxstdev.crashaddon.hud.HudIngamename;
import de.frxstdev.crashaddon.modules.*;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;

public class CrasherUtils extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("DrxemUtils", Items.COMMAND_BLOCK.getDefaultStack());
    public static final HudGroup HUD_GROUP = new HudGroup("DrxemUtils");

    @Override
    public void onInitialize() {
        LOG.info("Loaded Drxem's CrasherUtils");
        LOG.info("https://github.com/FrxstDev/meteor-crash-addon");
        LOG.info("https://youtube.com/@Drxem");
        LOG.info("https://discord.gg/wnhvkk7XWU");

        // Modules
        Modules.get().add(new ModuleExample());
        Modules.get().add(new AACCrash());
        Modules.get().add(new BookCrash());
        Modules.get().add(new CompletionCrash());
        Modules.get().add(new CreativeCrash());
        Modules.get().add(new ErrorCrash());
        Modules.get().add(new InteractCrash());
        Modules.get().add(new LecternCrash());
        Modules.get().add(new MessageLagger());
        Modules.get().add(new MovementCrash());
        Modules.get().add(new PacketSpammer());
        Modules.get().add(new SequenceCrash());
        Modules.get().add(new WindowCrash());

        // Commands
        Commands.add(new CrashItemCommand());

        // HUD
        Hud.get().register(HudCredits.INFO);
        Hud.get().register(HudIngamename.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "de.frxstdev.crashaddon";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("FrxstDev", "crash-addon");
    }
}
