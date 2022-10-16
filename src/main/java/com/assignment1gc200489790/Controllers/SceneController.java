package com.assignment1gc200489790.Controllers;
/*
 * Name: Arin Dhiman
 * Student num: 200489790
 * Date: 15 OCT 2022
 * Description: More Like a Util class but for me made sense to put in this package
 */


import com.assignment1gc200489790.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    /**
     * Method to change the scene and hence the stage as well
     * takes in an ActionEvent and name of the fxml file to load
     */
    public static void changeScene(ActionEvent event, String name) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }
}
