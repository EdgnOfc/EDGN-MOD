package com.edgn.modules.raids;

import com.edgn.main.config.Config;
import com.edgn.utils.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

import static com.edgn.main.BoolUtil.levelCheck;

public class AutoGuildXp {

    public AutoGuildXp() {
        run();
    }

    public void run() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;
        if (!Config.guildXpSetterBool) return;
        if (player.experienceLevel == 106 && (levelCheck)) {
            if (!levelCheck) {
                return;
            }
            levelCheck = false;
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!levelCheck) {
                    String command = "/gu xp 100";
                    player.sendChatMessage(command);
                }
            }).start();
        }
        if ((player.experienceLevel < 106) && (!levelCheck)) {
            if (levelCheck) {
                return;
            }
            levelCheck = true;
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (levelCheck) {
                    String command = "/gu xp 0";
                    player.sendChatMessage(command);
                }
            }).start();
        }
    }
}