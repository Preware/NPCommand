package me.raindropz.mc.npcommand.commands;

import me.raindropz.mc.npcommand.Npcommand;
import org.bukkit.ChatColor;
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

        if (command.getName().equalsIgnoreCase("npcommand")) {
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    plugin.saveDefaultConfig();
                    sender.sendMessage(ChatColor.YELLOW + "You have reloaded npcommand config files!");
                }
        }



        return false;
    }
}
