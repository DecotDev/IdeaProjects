package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onPlayButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load());

        stage.setScene(gameScene);
        stage.show();
    }

    @FXML
    private void onExitButtonClick(ActionEvent event) {
        System.exit(0);
    }
}
