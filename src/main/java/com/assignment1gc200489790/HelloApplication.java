package com.assignment1gc200489790;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Chart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Achievement Record");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        /*
        I generated the data.sql file using this code

        0.provide the matching game object for the achievements since this was done early on DB retrieval was not built for this object
        Game game = new Game(440, "Team Fortress 2", "Valve", 2007);

        1.made an api call with the steam game ID as a param
        ApiResponse response = APIUtil.apiCall(game.getSteamGameID());

        2.get the results
        Achievement[] achievements = response.getAchievementPercentages().getAchievements();

        3.pass them into the database
        DBUtil.insertAchievement(game, achievements);

        4.print out the sql statements to the console and copy them to the data file
         */
    }
}