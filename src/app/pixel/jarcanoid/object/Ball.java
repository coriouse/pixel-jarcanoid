package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;

public class Ball extends Mob {

	private float radius = 10f;
	private float moveX = 0;
	private float moveY = 0;
	private int direction = 1; // 1 - up, -1 - down
	private int corner = 1; // 0 - left, 1- right

	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		this.runSpeed = 5.0f;

	}

	public void update(float deltaTime) {

		System.out.println("direction == " + direction + "  && corner ==" + corner+", Platform.platfomDirection="+Platform.platfomDirection);

		// up
		if (doesCollide(posX, posY) && posY < 0) {
			if (direction == 1 && corner == 1) {
				direction = 1;
				corner = 0;
			} else if (direction == 1 && corner == 0) {
				direction = -1;
				corner = 0;
			}
			// down
		} else if (doesCollide(posX, posY) && posY > 0) {

			if (direction == -1 && corner == 0) {
				direction = -1;
				corner = 1;
			} else if (direction == -1 && corner == 1) {
				if (Platform.platfomDirection == 1) {
					direction = 1;
					corner = 1;
				} else if (Platform.platfomDirection == 0) {
					direction = 1;
					corner = 0;
				}
			}
		}

		// TODO defenition of ball direction
		/*
		 * Sprite[] sprites = getColliders(posX, posY); for(Sprite sprite :
		 * sprites) { if(sprite instanceof Platform) {
		 * System.out.println(sprite); } }
		 */

		if (direction == 1 && corner == 1) {
			posX += moveX * deltaTime + this.runSpeed;
			posY -= moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == 1 && corner == 0) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY -= moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == -1 && corner == 0) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY += moveY + 50 * deltaTime + this.runSpeed;
		} else if (direction == -1 && corner == 1) {
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

	public void changeDirection(int derection) {
		// TODO добавить enum Direction
		// TODO изменить на enum Direction.LEFT,...
		this.direction = direction;
	}
}
