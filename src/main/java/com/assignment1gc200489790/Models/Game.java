package com.assignment1gc200489790.Models;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Model class for Game objects
 */

import java.time.LocalDate;

public class Game {

    private long steamGameID;
    private String gameName;
    private String publisher;
    private int releaseYear;

    public Game(long steamGameID, String gameName, String publisher, int releaseYear) {
        setGameName(gameName);
        setSteamGameID(steamGameID);
        setReleaseYear(releaseYear);
        setPublisher(publisher);
    }

    /**
     * Getters for each attribute
     */
    public long getSteamGameID() {
        return steamGameID;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Setter method for each attribute with validation
     */
    public void setSteamGameID(long steamGameID) {
        if(steamGameID >= 0) {
            this.steamGameID = steamGameID;
        }
        else {
            throw new IllegalArgumentException("Invalid Game ID...");
        }
    }

    public void setGameName(String gameName) {
        if(!gameName.isEmpty()) {
            this.gameName = gameName;
        }
        else {
            throw new IllegalArgumentException("Invalid Game name...");
        }
    }

    public void setPublisher(String publisher) {
        if(!publisher.isEmpty() && publisher.matches("[a-zA-Z\\s]*")) {
            this.publisher = publisher;
        }
        else {
            throw new IllegalArgumentException("Invalid publisher name...");
        }
    }

    public void setReleaseYear(int releaseYear) {
        if(releaseYear >= 1900 && releaseYear <= LocalDate.now().getYear()) {
            this.releaseYear = releaseYear;
        }
        else {
            throw new IllegalArgumentException("Release Year cant be less than 1900 or in the future...");
        }
    }

    @Override
    public String toString() {
        return gameName;
    }
}
