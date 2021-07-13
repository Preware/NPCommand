package me.raindropz.mc.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.raindropz.mc.npcommand.Npcommand;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class NpcommandExpansion extends PlaceholderExpansion {


    private Npcommand plugin;


    public NpcommandExpansion(Npcommand plugin) {
        this.plugin = plugin;
    }


    @Override
    public @NotNull String getIdentifier() {
        return "npcs";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Raindropz";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if (p == null) {
            return "";
        }

        if (params.equals("hit")) {
            return String.valueOf(p.getPersistentDataContainer().get(new NamespacedKey(plugin, "npc-hit"), PersistentDataType.INTEGER));
        }

        return null;
    }
}
