package com.edgn.events;

import com.edgn.commands.raids.TnaSpeedrun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TnaSpeedrunTickEvent {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            EntityPlayer player = mc.player;
            if (player == null) return; // if the player is null, return

            TnaSpeedrun tnaSpeedrun = new TnaSpeedrun(); // create a new instance of TnaSpeedrun
            tnaSpeedrun.run(); // run the TnaSpeedrun code
        }
    }
}