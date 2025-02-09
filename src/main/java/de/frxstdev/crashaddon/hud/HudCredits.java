package de.frxstdev.crashaddon.hud;

import de.frxstdev.crashaddon.CrasherUtils;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class HudCredits extends HudElement {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public static final HudElementInfo<HudCredits> INFO = new HudElementInfo<>(CrasherUtils.HUD_GROUP, "credits", "HUD Credits", HudCredits::new);
    public HudCredits() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("2", true), renderer.textHeight(true));

        // Render background
        renderer.quad(x, y, getWidth(), getHeight(), Color.LIGHT_GRAY);

        // Render text
        renderer.text("6CrasherUtils §7made with §4<3 §7by §dDrxem §7ALIAS. §6FrxstDev", x, y, Color.WHITE, true);
    }
}
