package com.edgn.commands.help;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.edgn.utils.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class HelpPage1 extends CommandBase {
    @Override
    public String getName() {
        return "edh";
    }

    @Override
    public String getUsage(ICommandSender sender) {

        return "Montre toutes les commandes du mod EDGN";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = Minecraft.getMinecraft().player;

        String tag = ChatFormatting.BLACK + "[" + ChatFormatting.AQUA +"EDGN" +  ChatFormatting.BLACK +"]";
        ChatUtils.message(player, tag + ChatFormatting.GREEN + "");
        ChatUtils.message(player, tag + ChatFormatting.GREEN + " /edrhelp <page> : overall commands");
        ChatUtils.message(player, tag + ChatFormatting.GREEN + " /edr {player name} : shows raids stats ");
        ChatUtils.message(player, tag + ChatFormatting.GREEN + " Do /pa list if the party stats aren't displayed automatically after activating the party display module ");
        ChatUtils.message(player, tag + ChatFormatting.GREEN + "");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}