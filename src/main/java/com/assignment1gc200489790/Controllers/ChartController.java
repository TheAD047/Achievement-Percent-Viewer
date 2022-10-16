package com.assignment1gc200489790.Controllers;

import com.assignment1gc200489790.DBUtility.DBUtil;
import com.assignment1gc200489790.Models.Achievement;
import com.assignment1gc200489790.Models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChartController implements Initializable {


    @FXML
    private BarChart<Double, String> chart;

    @FXML
    private ComboBox<Game> gameComboBox;

    @FXML
    private Button goToGamesButton;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private CategoryAxis yAxis;

    @FXML
    private Label title;

    @FXML
    void getGamesView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "Games");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeGame(ActionEvent event) {
        title.setText(gameComboBox.getValue().getGameName());

        XYChart.Series<Double, String> data = new XYChart.Series<>();

        for(Achievement achievement : DBUtil.getAchievementsForGame(gameComboBox.getValue().getSteamGameID())){
            data.getData().add(new XYChart.Data<>(achievement.getPercentPlayers(),  achievement.getAchievementName()));
        }

        chart.getData().remove(0, chart.getData().size());
        data.setName("Percent(%) of Players who have completed the achievement");
        chart.getData().add(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Game> games = DBUtil.getGames();
        gameComboBox.getItems().addAll(games);
        gameComboBox.setValue(games.get(0));

        changeGame(new ActionEvent());
    }
}
