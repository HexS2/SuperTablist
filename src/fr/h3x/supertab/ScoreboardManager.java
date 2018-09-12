package fr.h3x.supertab;/*
SuperTablist @Author: CTRL 17:48
 */


import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {

    private static Scoreboard scoreboard;

    public ScoreboardManager(Scoreboard scoreboard) {

        this.scoreboard = scoreboard;
        removeTeams();
    }


    public static void setPrefix(Player player, TabRank pRank){
        String id = "TABLIST"+pRank.getPriority();

        Team team = scoreboard.getTeam(id);
        if (team == null)
        {
            team = scoreboard.registerNewTeam(id);
            team.setPrefix(pRank.getPrefix().replace('&','§'));
            team.setAllowFriendlyFire(true);
            team.setCanSeeFriendlyInvisibles(false);
        }
        team.addPlayer(player);
    }
    public static void removePlayerFromTeam(Player player){
        Team team = scoreboard.getPlayerTeam(player);
        if ((team != null) && (team.getName().startsWith("TABLIST"))) {
            team.removePlayer(player);
        }
    }

    public static void removeTeams()
    {
        if (scoreboard == null) {
            return;
        }
        for (Team team : scoreboard.getTeams()) {
            if (team.getName().startsWith("TABLIST")) {
                team.unregister();
            }
        }
    }
}
