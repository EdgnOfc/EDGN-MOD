package com.edgn.main.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    private static final String CATEGORY_GENERAL = "general";
    public static boolean tnaSpeedrunBool = true;
    public static boolean guildXpSetterBool = true;

    public static void loadConfig(File configFile) {
        Configuration config = new Configuration(configFile);
        config.load();

        tnaSpeedrunBool = config.getBoolean("tnaSpeedrunBool", CATEGORY_GENERAL, false, "Enable TNA Speedrun timer");
        guildXpSetterBool = config.getBoolean("guildXpSetterBool", CATEGORY_GENERAL, false, "Automatically sets guild xp % ");

        config.save();
    }

    public static void saveConfig() {
        Path configPath = Paths.get(System.getProperty("user.dir"), "config", "edgnraidutils.cfg");
        Configuration config = new Configuration(configPath.toFile());
        config.get(CATEGORY_GENERAL, "tnaSpeedrunBool", true).set(tnaSpeedrunBool);
        config.get(CATEGORY_GENERAL, "guildXpSetterBool", true).set(guildXpSetterBool);
        config.save();

    }
}

