package com.edgn.events;

import com.edgn.main.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.edgn.main.Main.tnaBoolTester;
import static com.edgn.main.config.Config.tnaSpeedrunBool;

public class ConfigEvent {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {

        if (event.phase == TickEvent.Phase.START) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            if (player == null) return;

            if (tnaSpeedrunBool == tnaBoolTester) {
                tnaBoolTester = !tnaSpeedrunBool;
                Config.saveConfig();
            }

        }
    }
}