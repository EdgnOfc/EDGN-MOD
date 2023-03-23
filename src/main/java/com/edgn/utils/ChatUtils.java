package com.edgn.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class ChatUtils {
    public static void message(EntityPlayer player, String message) {
        player.sendMessage(new TextComponentString(message));
    }
}