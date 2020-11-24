package application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class CueBall {
	private Circle ball;
	private Line directionLine;
	private double speed;

	CueBall(double xPos, double yPos, Color color) {
		ball = new Circle(xPos, yPos, 12, color);

		directionLine = new Line();

		ball.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				directionLine.setOpacity(1);
				directionLine.setStartX(ball.getCenterX());
				directionLine.setStartY(ball.getCenterY());
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
				shootCue((directionLine.getEndX() - directionLine.getStartX()), (directionLine.getEndY() - directionLine.getStartY()));
			}
		});
	}

	private void shootCue(double deltaX, double deltaY) {
		double angle = Math.atan2(deltaY, deltaX);
		speed = 1;
		double ballX = ball.getCenterX();
		double ballY = ball.getCenterY();

		while(!closeEnough()) {
			// TODO: ball just teleports
			ball.setCenterX(ballX += speed * Math.cos(angle));
			ball.setCenterY(ballY += speed * Math.sin(angle));

		}
	}

	private boolean closeEnough() {
		double dist = Math.sqrt(Math.pow(directionLine.getEndX() - ball.getCenterX(), 2) + Math.pow(directionLine.getEndX() - ball.getCenterX(), 2));
		if(dist < 20) {
			return true;
		} else { return false; }
	}

	public Circle getBall() {
		return ball;
	}

	public Line getDirectionLine() {
		return directionLine;
	}
}
