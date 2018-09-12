package fr.h3x.supertab;/*
SuperTablist @Author: CTRL 18:15
 */


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEvents implements Listener{

    private SuperTablist plugin;

    public PlayerEvents(SuperTablist plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler(priority= EventPriority.NORMAL)
    public void playerJoinEvent(PlayerJoinEvent event)
    {
        plugin.refreshTab(event.getPlayer());
        plugin.updateNameTag(event.getPlayer());
    }
    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent event)
    {
        ScoreboardManager.removePlayerFromTeam(event.getPlayer());
    }
}
