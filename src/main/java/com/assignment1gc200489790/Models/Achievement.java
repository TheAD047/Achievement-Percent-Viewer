package com.assignment1gc200489790.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Achievement {
    private long steamGameID;
    @JsonProperty("name")
    private String achievementName;
    @JsonProperty("percent")
    private double percentPlayers;


    public Achievement() {
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

    @Override
    public String toString() {
        return "Achievement{" +
                "steamGameID=" + steamGameID +
                ", achievementName='" + achievementName + '\'' +
                ", percentPlayers=" + percentPlayers +
                '}';
    }
}
