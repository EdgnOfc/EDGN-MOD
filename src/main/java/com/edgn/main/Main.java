package com.edgn.main;

import com.edgn.events.ConfigEvent;
import com.edgn.events.TickEvent;
import com.edgn.modules.help.HelpPage1;
import com.edgn.modules.raids.ShowPartyRaidCompletions;
import com.edgn.modules.raids.ShowRaidCompletions;
import com.edgn.keybinds.Keybinder;
import com.edgn.main.config.Config;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;

import static com.edgn.main.config.Config.tnaSpeedrunBool;


@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static boolean tnaBoolTester = !tnaSpeedrunBool;
    public static final String MODID = "edgnraidutils";
    public static final String NAME = "edgn mod";
    public static final String VERSION = "1.3.1";
    public static KeyBinding[] keyBindings;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.loadConfig(new File(event.getModConfigurationDirectory(), "edgnraidutils.cfg"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        keyBindings = new KeyBinding[2];

        keyBindings[0] = new KeyBinding("Party stats displayer toggler", Keyboard.KEY_P, "EDGN's MOD");
        keyBindings[1] = new KeyBinding("EDGN MOD GUI", Keyboard.KEY_8, "EDGN's MOD");


        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

        MinecraftForge.EVENT_BUS.register(new Keybinder());
        MinecraftForge.EVENT_BUS.register(new ShowPartyRaidCompletions());

        //Aide Commandes
        ClientCommandHandler.instance.registerCommand(new HelpPage1());
        //Raids Commandes and utilities
        ClientCommandHandler.instance.registerCommand(new ShowRaidCompletions());

        //more events
        MinecraftForge.EVENT_BUS.register(new TickEvent());
        MinecraftForge.EVENT_BUS.register(new ConfigEvent());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}