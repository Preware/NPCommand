package me.raindropz.mc.npcommand;

import net.citizensnpcs.api.event.NPCDamageByEntityEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class EntityDamageListener implements Listener {

    private final Npcommand plugin;
    public EntityDamageListener(Npcommand plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void EntityDamageByEntity(NPCDamageByEntityEvent event) {
        Entity entity = event.getNPC().getEntity();
        boolean isCitizensNPC = entity.hasMetadata("NPC");
        NPC npc = event.getNPC();

        ConfigurationSection path = plugin.getConfig().getConfigurationSection("NPCs");

        if (!(event.getDamager() instanceof Arrow && isCitizensNPC)) return;

        if (event.getDamager() instanceof Arrow) {

            for (String npcs : path.getKeys(false)) {
                int npcID = plugin.getConfig().getInt("NPCs." + npcs + ".id");


                if (npc.getId() == npcID) {
                    String command = plugin.getConfig().getString("NPCs." + npcs + ".command");
                    Location npcLoc = npc.getEntity().getLocation();

                    Firework firework = (Firework) npcLoc.getWorld().spawnEntity(npcLoc, EntityType.FIREWORK);
                    FireworkMeta fireworkMeta = firework.getFireworkMeta();

                    fireworkMeta.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
                    firework.setFireworkMeta(fireworkMeta);

                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.dispatchCommand(console, command);

                    event.getDamager().remove();

                }
            }
        }
    }
}