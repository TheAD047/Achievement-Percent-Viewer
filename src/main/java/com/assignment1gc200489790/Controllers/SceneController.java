package com.assignment1gc200489790.Controllers;

import com.assignment1gc200489790.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    public static void changeScene(ActionEvent event, String name) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }
}
