package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
	        Button playButton = new Button("Start Game");
	        playButton.setPrefSize(500, 50);
	        playButton.setStyle("-fx-font-size:40");
	        Button ruleButton = new Button("Rules");
	        ruleButton.setPrefSize(500, 50);
	        ruleButton.setStyle("-fx-font-size:40");
	        Button quitButton = new Button("Exit Game");
	        quitButton.setPrefSize(500, 50);
	        quitButton.setStyle("-fx-font-size:40");

	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setVgap(20);
	        grid.add(playButton, 0, 0);
	        grid.add(ruleButton, 0, 1);
	        grid.add(quitButton, 0, 2);

	        Scene scene = new Scene(grid, 1152, 648);
	        stage.setScene(scene);
	        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
