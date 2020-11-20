package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameScreen extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// outer table is the wooden looking part
		Rectangle outerTable = new Rectangle();
		outerTable.setX(230.4);
		outerTable.setY(129.6);
		outerTable.setWidth(691.2);
		outerTable.setHeight(388.8);
		outerTable.setArcWidth(40.0);
		outerTable.setArcHeight(40.0);
		outerTable.setFill(Color.SADDLEBROWN);

		// creates the inner table where balls will roll around
		Rectangle innerTable = new Rectangle();
		innerTable.setX(264.96);
		innerTable.setY(164.16);
		innerTable.setWidth(622.08);
		innerTable.setHeight(319.68);
		innerTable.setFill(Color.GREEN);

		// top left pocket
		Circle topLeftP = new Circle(265, 164, 18);

		// bottom left pocket
		Circle bottomLeftP = new Circle(265, 483.68, 18);

		//top right pocket
		Circle topRightP = new Circle(888, 164, 18);

		// bottom right pocket
		Circle bottomRightP = new Circle(888, 483.68, 18);

		// top middle pocket
		Circle topMidP = new Circle(576.5, 160, 18);

		// bottom middle pocket
		Circle bottomMidP = new Circle(576.5, 487.68, 18);

		// create cue ball
		Circle cueBall = new Circle(420.75, 321.84, 12, Color.WHITE);



		// the direction the ball will go in when shot is taken
		Line directionLine = new Line();
		// create the group object which holds all the objects of the scene
		Group group = new Group(outerTable, innerTable, topLeftP, bottomLeftP, topRightP, bottomRightP, topMidP, bottomMidP, cueBall, directionLine);
		Scene scene = new Scene(group, 1152, 648, Color.BEIGE);

		// TODO: probably should be moved to cue ball rather than scene
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setOpacity(1);
				directionLine.setStartX(event.getSceneX());
				directionLine.setStartY(event.getSceneY());
			}
		});

		// TODO: probably should be moved to cue ball rather than scene
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setEndX(directionLine.getStartX() - (event.getX() - directionLine.getStartX()));
				directionLine.setEndY(directionLine.getStartY() - (event.getY() - directionLine.getStartY()));
			}
		});

		// TODO: probably should be moved to cue ball rather than scene
		scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setOpacity(0);
			}
		});

		stage.setScene(scene);
		stage.show();
	}
}
