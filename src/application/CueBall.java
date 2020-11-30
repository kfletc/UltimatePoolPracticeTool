package application;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class CueBall {
	private Circle ball;
	private Line directionLine;

	CueBall(double xPos, double yPos, Color color) {
		ball = new Circle(xPos, yPos, 12, color);

		directionLine = new Line();

		ball.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setOpacity(1);
				directionLine.setStartX(ball.getCenterX());
				directionLine.setStartY(ball.getCenterY());
				directionLine.setEndX(ball.getCenterX());
				directionLine.setEndY(ball.getCenterY());
			}
		});

		ball.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setEndX(directionLine.getStartX() - (event.getX() - directionLine.getStartX()));
				directionLine.setEndY(directionLine.getStartY() - (event.getY() - directionLine.getStartY()));
			}
		});

		ball.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setOpacity(0);
				shootCue(directionLine.getEndX(), directionLine.getEndY());
			}
		});
	}

	private void shootCue(double xPos, double yPos) {
		PathTransition path = new PathTransition();
		path.setDuration(Duration.millis(1000));
		path.setNode(ball);
		path.setPath(directionLine);
		path.play();
		ball.setCenterX(xPos);
		ball.setCenterY(yPos);
	}

	public Circle getBall() {
		return ball;
	}

	public Line getDirectionLine() {
		return directionLine;
	}
}
