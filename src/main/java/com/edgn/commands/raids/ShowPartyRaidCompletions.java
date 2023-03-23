package com.edgn.commands.raids;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowPartyRaidCompletions {
    public static boolean partyBool = false;
    @SubscribeEvent
    public void ignoreChatMessage(ClientChatReceivedEvent event) throws InterruptedException {
        final Thread myThread = new Thread(() -> {
            if (!partyBool)  return;
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.player;
            String message = event.getMessage().getUnformattedText();
            if (message.contains("Party members:")) {
                Matcher matcher = Pattern.compile("([^:, ][A-Za-z0-9_]*)").matcher(message);
                while (matcher.find()) {
                    if (matcher.group(1).equals("Party") || matcher.group(1).equals("members")) {

                    } else {
                        ClientCommandHandler.instance.executeCommand(player, "/edr " + matcher.group(1));
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread.start();
    }
}