package com.edgn.events;

import com.edgn.modules.raids.AutoGuildXp;
import com.edgn.modules.raids.TnaSpeedrun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TickEvent {

    @SubscribeEvent
    public void onTick(net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent event) {
        if (event.phase == net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            if (player == null) return;
            TnaSpeedrun tnaSpeedrun = new TnaSpeedrun();
            tnaSpeedrun.run();
            AutoGuildXp autoGuildXp = new AutoGuildXp();
            autoGuildXp.run();
        }
    }
}