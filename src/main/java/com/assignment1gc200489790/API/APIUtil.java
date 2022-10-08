package com.assignment1gc200489790.API;

import com.assignment1gc200489790.Models.Achievement;
import com.assignment1gc200489790.Models.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtil {

    public static Achievement[] getApiResponse(String filename) {
        Gson gson = new Gson();

        try(
                FileReader reader = new FileReader(new File("C:\\java\\Assignment1-GC-200489790\\Assignment1-GC-200489790\\data.json"));
                JsonReader json = new JsonReader(reader);
                ) {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(reader.toString());
            Achievement[] achievements = objectMapper.readValue("", Achievement[].class);
            return  achievements;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApiResponse apiCall() {
        String url = "http://api.steampowered.com/ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?key=93629567E89D68A93DCB366A15ED6558&gameid=730&format=json";
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
