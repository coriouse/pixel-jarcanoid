package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import app.pixel.jarcanoid.game.Direction;
import app.pixel.jarcanoid.graphic.Render;

public class Ball extends Mob {

	private float radius = 10f;
	private float moveX = 0;
	private float moveY = 0;
	private Direction direction = Direction.UP_RIGHT;

	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		this.runSpeed = 5.0f;

	}

	public void update(float deltaTime) {

		

		// TODO need to resolve direction of the ball
		System.out.println("direction == " + direction);
		// up
		if (doesCollide(posX, posY) && posY < 0) {
			if (direction == Direction.UP_RIGHT) {
				if ((Platform.direction == Direction.RIGHT) &&  getSprite(getColliders(posX, posY)) instanceof Proof) {
					direction = Direction.DOWN_RIGHT;
				} else {
					direction = Direction.UP_LEFT;
				}
			} else if (direction == Direction.UP_LEFT) {

				if ((Platform.direction == Direction.LEFT) && getSprite(getColliders(posX, posY)) instanceof Proof) {
					direction = Direction.DOWN_LEFT;
				} else {
					direction = Direction.UP_RIGHT;
				}
			}
			// down
		} else if (doesCollide(posX, posY) && posY > 0) {
			if (direction == Direction.DOWN_LEFT) {
				if (Platform.direction == Direction.LEFT && getSprite(getColliders(posX, posY)) instanceof Platform) {
					direction = Direction.UP_LEFT;
				} else {
					direction = Direction.DOWN_RIGHT;
				}
			} else if (direction == Direction.DOWN_RIGHT) {
				if (Platform.direction == Direction.RIGHT && getSprite(getColliders(posX, posY)) instanceof Platform) {
					direction = Direction.UP_RIGHT;
				} else {
					direction = Direction.DOWN_LEFT;
				}
			}
		}

		if (direction == Direction.UP_RIGHT) {
			posX += moveX * deltaTime + this.runSpeed;
			posY -= moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == Direction.UP_LEFT) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY -= moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == Direction.DOWN_LEFT) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY += moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == Direction.DOWN_RIGHT) {
			posX += moveX * deltaTime + this.runSpeed;
			posY += moveY + 50 * deltaTime + this.runSpeed;
		}

	}

	public void render(Graphics g) {
		int x = 100;
		int y = 100;
		g.setColor(Color.green);

		g.fillOval(((int) (posX - width / 2) + Render.gameWidth / 2) - (int) radius,
				((int) (posY - height / 2) + Render.gameHeight / 2) - (int) radius, (int) radius * 2, (int) radius * 2);

	}
}
