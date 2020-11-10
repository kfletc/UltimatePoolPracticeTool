package com.mycompany.ultimatepoolpracticetool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button playButton = new Button("Start Game");
        Button ruleButton = new Button("Rules");
        Button quitButton = new Button("Exit Game");
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(playButton, ruleButton, quitButton);
        Scene scene = new Scene(vBox, 1152, 648);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}