package de.frxstdev.crashaddon.hud;

import de.frxstdev.crashaddon.CrasherUtils;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;
import net.minecraft.client.MinecraftClient;

public class HudIngamename extends HudElement {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public static final HudElementInfo<HudCredits> INFO = new HudElementInfo<>(CrasherUtils.HUD_GROUP, "IGN", "Show your Ingamename", HudCredits::new);
    public HudIngamename() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("2", true), renderer.textHeight(true));

        // Render background
        renderer.quad(x, y, getWidth(), getHeight(), Color.LIGHT_GRAY);

        // Render text
        renderer.text("§9[§bINGAMENAME§9] §b" + MinecraftClient.getInstance().getName().toString(), x, y, Color.WHITE, true);
    }
}
