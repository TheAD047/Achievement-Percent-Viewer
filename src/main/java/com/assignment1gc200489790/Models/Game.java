package com.assignment1gc200489790.Models;

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

    public void setSteamGameID(long steamGameID) {
        if(steamGameID >= 0) {
            this.steamGameID = steamGameID;
        }
        else {
            throw new IllegalArgumentException("Invalid Game ID...");
        }
    }

    public void setGameName(String gameName) {
        if(!gameName.isEmpty() && gameName.matches("[a-zA-Z\\s]*")) {
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
}
