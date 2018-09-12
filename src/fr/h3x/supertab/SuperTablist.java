package fr.h3x.supertab;/*
SuperTablist @Author: CTRL 16:44
 */

import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperTablist extends JavaPlugin{
    private static Permission perms = null;
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        new Configuration().loadGroups(getConfig());
        setupPermissions();
        setupScoreboard();

        new PlayerEvents(this);
        for (Player player : Bukkit.getOnlinePlayers())
        {
            updateNameTag(player);
            refreshTab(player);
        }

        System.out.println("Thank you for using SuperTablist");
    }
    public void setupScoreboard()
    {
        ScoreboardManager scoreboardManager = new ScoreboardManager(Bukkit.getScoreboardManager().getMainScoreboard());
    }

    public void  refreshTab(Player player){
        player.setPlayerListName(null);
    }
    public void updateNameTag(Player player){
        TabRank data;
        String group = perms.getPrimaryGroup(player);
        if (group == null) {
            return;
        }
        data = (TabRank) Configuration.groupMap.get(group.toLowerCase());
        if (data != null) {
            ScoreboardManager.setPrefix(player, data);
        }

    }
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Permission getPerms() {
        return perms;
    }
}
