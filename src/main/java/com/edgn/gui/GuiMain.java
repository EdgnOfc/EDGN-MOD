package com.edgn.gui;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

import static com.edgn.keybinds.Keybinder.*;
import static com.edgn.main.config.Config.tnaSpeedrunBool;

public class GuiMain extends GuiScreen {
    private static final int TNA_SPEEDRUN_BUTTON_ID = 0;
    private static final int WATCHED_COUNTER_BUTTON_ID = 1;
    private static final int NOTG_FIELD_ID = 2;
    private static final int NOL_FIELD_ID = 3;
    private static final int TCC_FIELD_ID = 4;
    private static final int TNA_FIELD_ID = 5;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 20;
    private static final String TNA_TOGGLE_ON_TEXT = ChatFormatting.GREEN + "Tna speedrun module : On";
    private static final String TNA_TOGGLE_OFF_TEXT = ChatFormatting.RED + "Tna speedrun module : Off";
    private static final String WATCHED_TOGGLE_ON_TEXT = ChatFormatting.GREEN + "Watched counter : On";
    private static final String WATCHED_TOGGLE_OFF_TEXT = ChatFormatting.RED + "Watched counter : Off";
    private boolean watchedCounter;
    private boolean tnaBoolButton = false;
    private boolean tccBoolButton = false;
    private boolean nolBoolButton = false;
    private boolean notgBoolButton = false;

    public GuiButton watchedCounterOn;
    public GuiButton watchedCounterOff;
    public GuiButton tnaSpeedrunButtonToggledOff;
    public GuiButton tnaSpeedrunButtonToggledOn;
    private final GuiButton notgButton;
    private final GuiButton nolButton;
    private final GuiButton tccButton;
    private final GuiButton tnaButton;
    public GuiMain() {
        tnaSpeedrunButtonToggledOff = new GuiButton(TNA_SPEEDRUN_BUTTON_ID, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, TNA_TOGGLE_OFF_TEXT);
        tnaSpeedrunButtonToggledOn = new GuiButton(TNA_SPEEDRUN_BUTTON_ID, 151, 0, BUTTON_WIDTH, BUTTON_HEIGHT, TNA_TOGGLE_ON_TEXT);
        watchedCounterOn = new GuiButton(WATCHED_COUNTER_BUTTON_ID, 151, 20, BUTTON_WIDTH, BUTTON_HEIGHT, WATCHED_TOGGLE_ON_TEXT);
        watchedCounterOff = new GuiButton(WATCHED_COUNTER_BUTTON_ID, 151, 20, BUTTON_WIDTH, BUTTON_HEIGHT, WATCHED_TOGGLE_OFF_TEXT);
        tnaButton = new GuiButton(TNA_FIELD_ID, 0, 60, BUTTON_WIDTH, BUTTON_HEIGHT, "TNA MODULES");
        tccButton = new GuiButton(TCC_FIELD_ID, 0, 40, BUTTON_WIDTH, BUTTON_HEIGHT, "TCC MODULES");
        nolButton = new GuiButton(NOL_FIELD_ID, 0, 20, BUTTON_WIDTH, BUTTON_HEIGHT, "NOL MODULES");
        notgButton = new GuiButton(NOTG_FIELD_ID, 0, 0, BUTTON_WIDTH, BUTTON_HEIGHT, "NOTG MODULES");
    }

    public void initGui() {
        buttonList.clear();
        addToggleButton(notgButton, true);
        addToggleButton(nolButton, true);
        addToggleButton(tccButton, true);
        addToggleButton(tnaButton, true);
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
            if (watchedCounter) {
                addToggleButton(watchedCounterOn, true);
            } else {
                addToggleButton(watchedCounterOff, true);
            }
        }

        if (!notgBoolButton) {
            addToggleButton(notgButton, true);
        } else {
            addToggleButton(notgButton, false);
            addToggleButton(nolButton, true);
            addToggleButton(tccButton, true);
            addToggleButton(tnaButton, true);
        }

        if (!nolBoolButton){
            addToggleButton(nolButton, true);
        } else {
            addToggleButton(notgButton, true);
            addToggleButton(nolButton, false);
            addToggleButton(tccButton, true);
            addToggleButton(tnaButton, true);
        }
        if (!tccBoolButton){
            addToggleButton(tccButton, true);
        } else {
            addToggleButton(notgButton, true);
            addToggleButton(nolButton, true);
            addToggleButton(tccButton, false);
            addToggleButton(tnaButton, true);
        }
        if (!tnaBoolButton){
            addToggleButton(tnaButton, true);
        } else {
            addToggleButton(notgButton, true);
            addToggleButton(nolButton, true);
            addToggleButton(tccButton, true);
            addToggleButton(tnaButton, false);
        }

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == tnaSpeedrunButtonToggledOff || button == tnaSpeedrunButtonToggledOn) {
            tnaSpeedrunBool = !tnaSpeedrunBool;
        }
        if (button == watchedCounterOn || button == watchedCounterOff) {
            watchedCounter = !watchedCounter;
        }
        if (button == notgButton) {
            nolBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = false;
            notgBoolButton = !notgBoolButton;
        }
        if (button == nolButton) {
            notgBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = false;
            nolBoolButton = !nolBoolButton;
        }
        if (button == tccButton) {
            notgBoolButton = false;
            nolBoolButton = false;
            tnaBoolButton = false;
            tccBoolButton = !tccBoolButton;
        }
        if (button == tnaButton) {
            notgBoolButton = false;
            nolBoolButton = false;
            tccBoolButton = false;
            tnaBoolButton = !tnaBoolButton;
        }
        initGui();
    }

    private void addToggleButton(GuiButton button, boolean enabled) {
        button.enabled = enabled;
        buttonList.add(button);
    }

    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }
}
