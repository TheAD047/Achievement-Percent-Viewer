package com.assignment1gc200489790.Controllers;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: Controller for CreateGame.fxml file
 */


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

    /**
     * Go To the Games.fxml view
     */
    @FXML
    void getGamesView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "Games");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in all the values in the text fields and tries to add the game
     * Calls the api to fetch achievements for that game and if there is data returned
     * it is added to the DB, It takes quite a bit of time
     * please wait for text to appear at the bottom of the scene
     * keep an eye on the console for "setText Didnt work" message if it is taking a long time
     */
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

    /**
     * dedicated method to set the text value for the label
     * because for some reason I got null pointer exception
     */
    void updateTitle(ActionEvent event ,String text) {
        try {
            statusLabel.setText(text);
        }
        catch (Exception e) {
            System.out.println("setText Didnt work...");
        }
    }

}
