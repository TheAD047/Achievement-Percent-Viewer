package com.assignment1gc200489790.Models;

public class Achievement {
    private long steamGameID;
    private String achievementName;
    private double percentPlayers;

    public Achievement(long steamGameID, String achievementName, double percentPlayers) {
        setSteamGameID(steamGameID);
        setAchievementName(achievementName);
        setPercentPlayers(percentPlayers);
    }

    public long getSteamGameID() {
        return steamGameID;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public double getPercentPlayers() {
        return percentPlayers;
    }

    public void setSteamGameID(long steamGameID) {
        if(steamGameID >= 0) {
            this.steamGameID = steamGameID;
        }
        else {
            throw new IllegalArgumentException("Invalid Game ID...");
        }
    }

    public void setAchievementName(String achievementName) {
        if(!achievementName.isEmpty()) {
            //omitted regex matching because of underscores
            this.achievementName = achievementName;
        }
        else {
            throw new IllegalArgumentException("Achievement name cant be empty...");
        }
    }

    public void setPercentPlayers(double percentPlayers) {
        if(percentPlayers > 0) {
            this.percentPlayers = percentPlayers;
        }
        else {
            throw new IllegalArgumentException("Illegal percent value...");
        }
    }
}
