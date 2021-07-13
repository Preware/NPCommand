package me.raindropz.mc.listeners;

import me.raindropz.mc.npcommand.Npcommand;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerJoin implements Listener {

    private final Npcommand plugin;

    public PlayerJoin(Npcommand plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        PersistentDataContainer npcHitCount = e.getPlayer().getPersistentDataContainer();
        NamespacedKey npcHit = new NamespacedKey(plugin, "npc-hit");

        if (!npcHitCount.has(npcHit, PersistentDataType.INTEGER)) {
            npcHitCount.set(new NamespacedKey(plugin, "npc-hit"), PersistentDataType.INTEGER, 0);
            System.out.println("Working?");
        }

    }

}
