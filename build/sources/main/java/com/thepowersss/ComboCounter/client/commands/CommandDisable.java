package com.thepowersss.ComboCounter.client.commands;

import com.thepowersss.ComboCounter.tab.ComboCounter;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandDisable implements ICommand {
    private final List<String> aliases;

    public CommandDisable () {
        aliases = new ArrayList<>();
        aliases.add("ccdisable");
        aliases.add("ccoff");
        aliases.add("ccd");
    }
    @Override
    public String getName() {
        return "ccdisable";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "ccdisable";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        MinecraftForge.EVENT_BUS.unregister(ComboCounter.HANDLER);
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Combo Counter disabled."));
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
