package com.assignment1gc200489790.API;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Class built specifically for calling and parsing data from API
 */

import com.assignment1gc200489790.Models.ApiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtil {

    /**
     * Calls and receives data from api, then parses it into ApiResponse model
     * @param gameID is used to fetch data for that specific game
     * @return
     */
    public static ApiResponse apiCall(long gameID) {
        String url = "http://api.steampowered.com/ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?key=93629567E89D68A93DCB366A15ED6558&gameid="+ gameID + "&format=json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponse data = objectMapper.readValue(response.body(), ApiResponse.class);
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
