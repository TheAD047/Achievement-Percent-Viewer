package com.assignment1gc200489790.Controllers;

import com.assignment1gc200489790.API.APIUtil;
import com.assignment1gc200489790.DBUtility.DBUtil;
import com.assignment1gc200489790.Models.ApiResponse;
import com.assignment1gc200489790.Models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.security.InvalidParameterException;

public class CreateGameController {

    @FXML
    private Label statusLabel;

    @FXML
    private Label title;

    @FXML
    private TextField fieldForID;

    @FXML
    private TextField fieldForName;

    @FXML
    private TextField fieldForPublisher;

    @FXML
    private TextField fieldForYear;

    @FXML
    private Button getGamesViewBTN;

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
    void createGame(ActionEvent event) {
        try{
            updateTitle(event, "Adding Please Wait...");
            Game game = new Game(
                    Long.parseLong(fieldForID.getText()),
                    fieldForName.getText(),
                    fieldForPublisher.getText(),
                    Integer.parseInt(fieldForYear.getText())
            );

            ApiResponse response = APIUtil.apiCall(game.getSteamGameID());

            if(response.getAchievementPercentages().getAchievements().length > 0) {
                DBUtil.insertGame(game);
                DBUtil.insertAchievement(game, response.getAchievementPercentages().getAchievements());
                updateTitle(new ActionEvent(),"Game and Achievements Added");
            }
            else {
                throw new InvalidParameterException("invalid steam ID...");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            updateTitle(new ActionEvent() ,"Something went wrong");
        }
    }

    void updateTitle(ActionEvent event ,String text) {
        statusLabel.setText(text);
    }

}
