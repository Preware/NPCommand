package me.raindropz.mc.npcommand;
import me.raindropz.mc.npcommand.commands.reloadCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Npcommand extends JavaPlugin {
    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
        Bukkit.getConsoleSender().sendMessage("NPCommand Version:" + getConfig().getString("version") + "by Raindropz is now enabled.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();


        getCommand("npcommand").setExecutor(new reloadCommand(this));

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("NPCommand Version:" + getConfig().getString("version") + "by Raindropz is now disabled.");
    }
}
