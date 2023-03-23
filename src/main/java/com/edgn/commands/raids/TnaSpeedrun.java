package com.edgn.commands.raids;

import com.edgn.utils.ChatUtils;
import com.edgn.utils.SpeedrunTimer;
import com.edgn.utils.SpeedrunTimerByRoom;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import static com.edgn.keybinds.Keybinder.*;


public class TnaSpeedrun {
    public static boolean tnaSpeedrunBool = false;

    public TnaSpeedrun() {
        run();
    }

    public void run() {

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        String tag = ChatFormatting.BLACK + "[" + ChatFormatting.AQUA + "EDGN" + ChatFormatting.BLACK + "] " + ChatFormatting.GOLD;


        if (!tnaSpeedrunBool) return;

        if (starter && (player.getPosition().getX() >= 27770
                && player.getPosition().getX() <= 27780 && player.getPosition().getZ() >= -22054
                    && player.getPosition().getZ() <= -22044 || player.getPosition().getX() >= 24489
                        && player.getPosition().getX() <= 24499 && player.getPosition().getZ() >= -22687
                            && player.getPosition().getZ() <= -22677)) {

            SpeedrunTimer.start();
            SpeedrunTimerByRoom.start();
            starter = false;
            verify = false;
            failChecker = false;
        }

        if (!starter && !verify && (player.getPosition().getX() >= 24902 && player.getPosition().getX() <= 24912
                && player.getPosition().getZ() >= -23989  && player.getPosition().getZ() <= -23979)) {

            ChatUtils.message(player, tag + "Room 1 time spent : " + ChatFormatting.BLUE  + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();

            starter = true;

        }

        if (!verify && starter && (player.getPosition().getX() >= 24246
                && player.getPosition().getX() <= 24256 && player.getPosition().getZ() >= -22264
                    && player.getPosition().getZ() <= -22254 || player.getPosition().getX() >= -12723
                        && player.getPosition().getX() <= -12713 && player.getPosition().getZ() >= 8369
                            && player.getPosition().getZ() <= 8379)) {

            ChatUtils.message(player, tag + "Buff room 1 time spent : " + ChatFormatting.BLUE + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();
            starter = false;
        }


        if (!starter && !verify && (player.getPosition().getX() >= 24902 && player.getPosition().getX() <= 24912
                && player.getPosition().getZ() >= -23787  && player.getPosition().getZ() <= -23757)) { //24907, -23772

            ChatUtils.message(player, tag + "Room 2 time spent : " + ChatFormatting.BLUE  + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();
            starter = true;

        }


        if (!verify && starter && (player.getPosition().getX() >= 25577
                && player.getPosition().getX() <= 25587 && player.getPosition().getZ() >= -23539
                    && player.getPosition().getZ() <= -23529 || player.getPosition().getX() >= 23477
                        && player.getPosition().getX() <= 23487 && player.getPosition().getZ() >= -22040
                            && player.getPosition().getZ() <= -22030)) {

            ChatUtils.message(player, tag + "Buff room 2 time spent : " + ChatFormatting.BLUE  + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();

            starter = false;
            //ins
        }


        if (!starter && !verify && (player.getPosition().getX() >= 24902 && player.getPosition().getX() <= 24912
                && player.getPosition().getZ() >= -23565  && player.getPosition().getZ() <= -23555)) {

            starter = true;

            ChatUtils.message(player, tag + "Room 3 time spent : " + ChatFormatting.BLUE  + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();
            //ins
        }


        if (starter && !verify && (player.getPosition().getX() >= 26608 && player.getPosition().getX() <= 26618
                && player.getPosition().getZ() >= -22141  && player.getPosition().getZ() <= -22131)) {

            ChatUtils.message(player, tag + "Buff room 3 time spent : " + ChatFormatting.BLUE + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();

            starter = false;
            //ins
        }


        if (!starter && !verify && (player.getPosition().getX() >= 24400 && player.getPosition().getX() <= 24550
                && player.getPosition().getZ() >= -23950  && player.getPosition().getZ() <= -23800)) {

            ChatUtils.message(player, tag + "Boss room time spent : " + ChatFormatting.BLUE + SpeedrunTimerByRoom.stop());
            SpeedrunTimerByRoom.stop();
            SpeedrunTimerByRoom.start();

            starter = true;
            verify = true;
            failChecker = true;
            ChatUtils.message(player, tag + "Raid finished in : " + ChatFormatting.GOLD + SpeedrunTimer.stop());
            SpeedrunTimer.stop();
        }


        if (!verify && !failChecker && (player.getPosition().getX() >= 1115 && player.getPosition().getX() <= 1125
                && player.getPosition().getZ() >= -858  && player.getPosition().getZ() <= -848)) {

            SpeedrunTimer.stop();
            SpeedrunTimerByRoom.stop();

            starter = true;
            verify = true;
            failChecker = true;

            ChatUtils.message(player, tag + ChatFormatting.GOLD + "Skill Issue");
        }

    }
}