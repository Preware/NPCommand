package me.raindropz.mc.npcommand;

import me.raindropz.mc.commands.reloadCommand;
import me.raindropz.mc.listeners.EntityDamageListener;
import me.raindropz.mc.listeners.PlayerJoin;
import me.raindropz.mc.placeholders.NpcommandExpansion;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Npcommand extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getConsoleSender().sendMessage("NPCommand Version:" + getConfig().getString("version") + "by Raindropz is now enabled.");

        getCommand("npcommand").setExecutor(new reloadCommand(this));

        new NpcommandExpansion(this).register();

    }
    @Override
    public void onDisable() {
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("NPCommand Version:" + getConfig().getString("version") + "by Raindropz is now disabled.");
    }
}
