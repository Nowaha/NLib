package xyz.nowaha.nlib.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand {

    public abstract void onCommand(CommandSender sender, String label, String[] args);
    public abstract String getName();
    public abstract List<String> getAliases();
    public abstract String getPermission();
    public abstract String getDescription();
    public abstract String getUsage();

}
