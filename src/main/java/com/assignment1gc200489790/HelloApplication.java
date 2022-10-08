package com.assignment1gc200489790;

import com.assignment1gc200489790.API.APIUtil;
import com.assignment1gc200489790.Models.Achievement;
import com.assignment1gc200489790.Models.AchievementPercentages;
import com.assignment1gc200489790.Models.ApiResponse;

public class HelloApplication {
    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
        //launch();

        ApiResponse response = APIUtil.apiCall();
        Achievement[] achievements = response.getAchievementPercentages().getAchievements();
        for(Achievement a : achievements) {
            a.setSteamGameID(730);
            System.out.println(a);
        }
    }
}