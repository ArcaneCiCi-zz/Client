package net.minecraft.client.render.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.setting.GameSettings;

public class MovementInputFromOptions extends MovementInput {

    private final boolean[] somethingTodoWithMovement;
    private final GameSettings field_1178_g;

    public MovementInputFromOptions(GameSettings gamesettings) {
        somethingTodoWithMovement = new boolean[10];
        field_1178_g = gamesettings;
    }

    public void move(int i, boolean flag) {
        byte byte0 = -1;
        if (i == field_1178_g.keyBindForward.keyCode) {
            byte0 = 0;
        }
        if (i == field_1178_g.keyBindBack.keyCode) {
            byte0 = 1;
        }
        if (i == field_1178_g.keyBindLeft.keyCode) {
            byte0 = 2;
        }
        if (i == field_1178_g.keyBindRight.keyCode) {
            byte0 = 3;
        }
        if (i == field_1178_g.keyBindJump.keyCode) {
            byte0 = 4;
        }
        if (i == field_1178_g.keyBindSneak.keyCode) {
            byte0 = 5;
        }
        if (byte0 >= 0) {
            somethingTodoWithMovement[byte0] = flag;
        }
    }

    public void func_798_a() {
        for (int i = 0; i < 10; i++) {
            somethingTodoWithMovement[i] = false;
        }

    }

    public void movePlayer(EntityPlayer entityplayer) {
        moveStrafe = 0.0F;
        moveForward = 0.0F;
        if (somethingTodoWithMovement[0]) {
            moveForward++;
        }
        if (somethingTodoWithMovement[1]) {
            moveForward--;
        }
        if (somethingTodoWithMovement[2]) {
            moveStrafe++;
        }
        if (somethingTodoWithMovement[3]) {
            moveStrafe--;
        }
        jump = somethingTodoWithMovement[4];
        sneak = somethingTodoWithMovement[5];
        if (sneak) {
            moveStrafe *= 0.29999999999999999D;
            moveForward *= 0.29999999999999999D;
        }
    }
}
