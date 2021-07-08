package me.raindropz.mc.npcommand.commands;

import me.raindropz.mc.npcommand.Npcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadCommand implements CommandExecutor {

    private final Npcommand plugin;


    public reloadCommand(Npcommand plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
