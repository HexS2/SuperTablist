package fr.h3x.supertab;/*
SuperTablist @Author: CTRL 17:46
 */

public class TabRank {
    private String prefix;
    private String priority;
    public TabRank(String prefix, String priority) {
        this.prefix = prefix;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public String getPrefix() {
        return prefix;
    }



}
