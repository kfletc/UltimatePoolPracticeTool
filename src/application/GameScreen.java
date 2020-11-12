package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameScreen extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Rectangle outerTable = new Rectangle();
		outerTable.setX(230.4);
		outerTable.setY(129.6);
		outerTable.setWidth(691.2);
		outerTable.setHeight(388.8);

		Group group = new Group(outerTable);
		Scene scene = new Scene(group, 1152, 648);
		stage.setScene(scene);
		stage.show();
	}
}
