package com.assignment1gc200489790.Models;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Model class for achievement
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Achievement {

    private long steamGameID;

    @JsonProperty("name")
    private String achievementName;

    @JsonProperty("percent")
    private double percentPlayers;

    /**
     * default constructor for Jackson library to instantiate an achievement object from JSON feed
     */
    public Achievement() {
    }

    /**
     * All args constructor for retrieving achievement objects from DB
     */
    public Achievement(long steamGameID, String achievementName, double percentPlayers) {
        setSteamGameID(steamGameID);
        setAchievementName(achievementName);
        setPercentPlayers(percentPlayers);
    }

    /**
     * Getters for each attribute
     */
    public long getSteamGameID() {
        return steamGameID;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public double getPercentPlayers() {
        return percentPlayers;
    }

    /**
     * Setters for each attribute with validation
     */
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
