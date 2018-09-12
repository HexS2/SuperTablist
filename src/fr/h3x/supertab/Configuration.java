package fr.h3x.supertab;/*
SuperTablist @Author: CTRL 17:47
 */
import org.bukkit.configuration.file.FileConfiguration;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Configuration {

    public Configuration() {
    }

    public static Map<String, TabRank> groupMap;

    public void loadGroups(FileConfiguration config) {
        groupMap = new HashMap();
        Set<String> groupKeys = config.getKeys(false);
        if ((groupKeys != null) && (groupKeys.size() > 0)) {
            for (String group : groupKeys) {
                String prefix = config.getString(group);
                String priority = prefix.substring(0,1);
                groupMap.put(group.toLowerCase(), new TabRank(prefix.substring(1),priority));
            }
        }

    }
}