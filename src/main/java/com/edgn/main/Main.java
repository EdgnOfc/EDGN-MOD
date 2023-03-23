package com.edgn.main;

import com.edgn.events.TnaSpeedrunTickEvent;
import org.lwjgl.input.Keyboard;

import com.edgn.commands.help.HelpPage1;
import com.edgn.commands.raids.ShowPartyRaidCompletions;
import com.edgn.commands.raids.ShowRaidCompletions;
import com.edgn.keybinds.Keybinder;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {

    public static final String MODID = "edgnraidutils";
    public static final String NAME = "edgn mod";
    public static final String VERSION = "1.2";
    public static KeyBinding[] keyBindings;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        keyBindings = new KeyBinding[2];

        keyBindings[0] = new KeyBinding("Party stats displayer toggler", Keyboard.KEY_P, "EDGN's RAID UTILITY");
        keyBindings[1] = new KeyBinding("Tna speedrun toggler", Keyboard.KEY_H, "EDGN's RAID UTILITY");

        for (int i = 0; i < keyBindings.length; ++i)
        {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }

        MinecraftForge.EVENT_BUS.register(new Keybinder());
        MinecraftForge.EVENT_BUS.register(new ShowPartyRaidCompletions());

        //Aide Commandes
        ClientCommandHandler.instance.registerCommand(new HelpPage1());
        //Raids Commandes and utilities
        ClientCommandHandler.instance.registerCommand(new ShowRaidCompletions());
        MinecraftForge.EVENT_BUS.register(new TnaSpeedrunTickEvent());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}