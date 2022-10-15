package com.assignment1gc200489790.Controllers;


import com.assignment1gc200489790.DBUtility.DBUtil;
import com.assignment1gc200489790.Models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Button AddGameBTN;

    @FXML
    private Button ViewChartBTN;

    @FXML
    private TableView<Game> gameTable;

    @FXML
    private TableColumn<Game, String> nameCol;

    @FXML
    private TableColumn<Game, String> publisherCol;

    @FXML
    private TableColumn<Game, Long> steamIDCol;

    @FXML
    private TableColumn<Game, Integer> yearCol;


    @FXML
    void getAddGameView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "CreateGame");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void getChartView(ActionEvent event) {
        try {
            SceneController.changeScene(event, "Chart");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        steamIDCol.setCellValueFactory(new PropertyValueFactory<>("steamGameID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        gameTable.getItems().addAll(DBUtil.getGames());
    }
}
