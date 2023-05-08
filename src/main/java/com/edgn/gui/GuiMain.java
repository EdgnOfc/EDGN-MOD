package com.edgn.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import static com.edgn.keybinds.Keybinder.*;
import static com.edgn.main.config.Config.*;

public class GuiMain extends GuiScreen {
    private static final int TNA_SPEEDRUN_BUTTON_ID = 0;
    private static final int BULB_KEEPER_WATCHER = 1;
    private static final int NOTG_FIELD_ID = 2;
    private static final int NOL_FIELD_ID = 3;
    private static final int TCC_FIELD_ID = 4;
    private static final int TNA_FIELD_ID = 5;
    private static final int MISC_FIELD_ID = 6;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 20;
    private static final String TNA_TOGGLE_ON_TEXT = ChatFormatting.GREEN + "Tna speedrun module : On";
    private static final String TNA_TOGGLE_OFF_TEXT = ChatFormatting.RED + "Tna speedrun module : Off";
    private static final String ENTITY_HIGHLIGHTER_ON_TEXT = ChatFormatting.GREEN + "Bulb Keeper warning : On";
    private static final String ENTITY_HIGHLIGHTER_OFF_TEXT = ChatFormatting.RED + "Bulb Keeper warning : Off";
    private boolean tnaBoolButton = false;
    private boolean tccBoolButton = false;
    private boolean nolBoolButton = false;
    private boolean notgBoolButton = false;
    private boolean miscBoolButton = false;

    private final GuiButton tnaSpeedrunButtonToggledOff;
    private final  GuiButton tnaSpeedrunButtonToggledOn;
    private final GuiButton notgButton;
    private final GuiButton nolButton;
    private final GuiButton tccButton;
    private final GuiButton tnaButton;
    private final GuiButton miscButton;
    private final GuiButton guildXpSetterOn;
    private final GuiButton guildXpSetterOff;

    public GuiMain() {
        tnaSpeedrunButtonToggledOff = new GuiButton(TNA_SPEEDRUN_BUTTON_ID, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, TNA_TOGGLE_OFF_TEXT);
        tnaSpeedrunButtonToggledOn = new GuiButton(TNA_SPEEDRUN_BUTTON_ID, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, TNA_TOGGLE_ON_TEXT);

        tnaButton = new GuiButton(TNA_FIELD_ID, 0, 60, BUTTON_WIDTH, BUTTON_HEIGHT, "TNA MODULES");
        tccButton = new GuiButton(TCC_FIELD_ID, 0, 40, BUTTON_WIDTH, BUTTON_HEIGHT, "TCC MODULES");
        nolButton = new GuiButton(NOL_FIELD_ID, 0, 20, BUTTON_WIDTH, BUTTON_HEIGHT, "NOL MODULES");
        notgButton = new GuiButton(NOTG_FIELD_ID, 0, 0, BUTTON_WIDTH, BUTTON_HEIGHT, "NOTG MODULES");
        miscButton = new GuiButton(MISC_FIELD_ID , 0, 80, BUTTON_WIDTH, BUTTON_HEIGHT, "MISCELLANEOUS");

        guildXpSetterOn = new GuiButton(7, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, ChatFormatting.GREEN + "Auto Guild Xp Set : On");
        guildXpSetterOff = new GuiButton(7, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, ChatFormatting.RED + "Auto Guild Xp Set : Off");
    }

    public void initGui() {
        buttonList.clear();
        addToggleButton(notgButton, true);
        addToggleButton(nolButton, true);
        addToggleButton(tccButton, true);
        addToggleButton(tnaButton, true);
        addToggleButton(miscButton, true);
        if (tnaBoolButton) {
            if (tnaSpeedrunBool) {
                addToggleButton(tnaSpeedrunButtonToggledOn, true);
                verify = true;
                starter = true;
                failChecker = true;
            } else {
                addToggleButton(tnaSpeedrunButtonToggledOff, true);
                verify = false;
                starter = false;
                failChecker = false;
            }
        }
        if (miscBoolButton) {
            if (guildXpSetterBool) {
                addToggleButton(guildXpSetterOn, true);
            } else {
                addToggleButton(guildXpSetterOff, true);
            }
        }


        addToggleButton(notgButton, !notgBoolButton);
        addToggleButton(nolButton, !nolBoolButton);
        addToggleButton(tccButton, !tccBoolButton);
        addToggleButton(tnaButton, !tnaBoolButton);
        addToggleButton(miscButton, !miscBoolButton);

    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button == tnaSpeedrunButtonToggledOff || button == tnaSpeedrunButtonToggledOn) {
            tnaSpeedrunBool = !tnaSpeedrunBool;
        }
        if (button == guildXpSetterOn || button == guildXpSetterOff) {
            guildXpSetterBool = !guildXpSetterBool;
        }
        if (button == notgButton) {
            nolBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = false;
            miscBoolButton = false;
            notgBoolButton = !notgBoolButton;
        }
        if (button == nolButton) {
            notgBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = false;
            miscBoolButton = false;
            nolBoolButton = !nolBoolButton;
        }
        if (button == tccButton) {
            notgBoolButton = false;
            nolBoolButton = false;
            tnaBoolButton = false;
            miscBoolButton = false;
            tccBoolButton = !tccBoolButton;
        }
        if (button == tnaButton) {
            notgBoolButton = false;
            nolBoolButton = false;
            tccBoolButton = false;
            miscBoolButton = false;
            tnaBoolButton = !tnaBoolButton;
        }
        if(button == miscButton){
            notgBoolButton = false;
            nolBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = false;
            miscBoolButton = !miscBoolButton;
        }
        initGui();
    }

    private void addToggleButton(GuiButton button, boolean enabled) {
        button.enabled = enabled;
        buttonList.add(button);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
