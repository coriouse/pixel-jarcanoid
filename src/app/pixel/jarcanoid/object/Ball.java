package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import com.sun.glass.events.KeyEvent;

import app.pixel.jarcanoid.game.Direction;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.input.Input;

public class Ball extends Mob {

	private float radius = 10f;
	private float moveX = 0;
	private float moveY = 0;
	private Direction direction = Direction.UP;

	private int push = -1; // 1 - push, -1 - pull
	
	public static int LIFES = 3;
	public static int SCORE = 0;

	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		this.runSpeed = 5.0f;

	}

	public void update(float deltaTime) {

		if (Input.getKey(KeyEvent.VK_SPACE)) {

			push = 1;
		}

		if (push == 1) {
			// TODO need to resolve normal direction of the ball
			Sprite[] sprites = getColliders(posX, posY);
			System.out.println("Platform.direction=[" + Platform.direction + "], direction=[" + direction + "],"
					+ Arrays.toString(sprites) + ", posY=" + posY + ", posX=" + posX);

			if (sprites.length > 0) {
				if (direction == Direction.UP && Platform.direction == Direction.FREE
						&& (getSprite(sprites) instanceof Proof || getSprite(sprites) instanceof Block)) {
					direction = Direction.DOWN;
				} else if (direction == Direction.DOWN && Platform.direction == Direction.FREE
						&& (getSprite(sprites) instanceof Platform || getSprite(sprites) instanceof Block)) {
					direction = Direction.UP;
				} else if ((direction == Direction.DOWN || direction == Direction.UP)
						&& Platform.direction == Direction.RIGHT) {
					direction = Direction.UP_RIGHT;
				} else if ((direction == Direction.DOWN || direction == Direction.UP)
						&& Platform.direction == Direction.LEFT) {
					direction = Direction.UP_LEFT;
				} else if (direction == Direction.UP_RIGHT
						&& (getSprite(sprites) instanceof Proof || getSprite(sprites) instanceof Block)) {
					direction = Direction.DOWN_RIGHT;
				} else if (direction == Direction.UP_RIGHT
						&& (getSprite(sprites) instanceof WallRight || getSprite(sprites) instanceof Block)) {
					direction = Direction.UP_LEFT;
				} else if (direction == Direction.UP_LEFT
						&& (getSprite(sprites) instanceof Proof || getSprite(sprites) instanceof Block)) {
					direction = Direction.DOWN_LEFT;
				} else if (direction == Direction.DOWN_LEFT
						&& (getSprite(sprites) instanceof Platform || getSprite(sprites) instanceof Block)) {
					direction = Direction.UP_LEFT;
				} else if (direction == Direction.DOWN_LEFT
						&& (getSprite(sprites) instanceof WallLeft || getSprite(sprites) instanceof Block)) {
					direction = Direction.DOWN_RIGHT;
				} else if (direction == Direction.UP_LEFT
						&& (getSprite(sprites) instanceof WallLeft || getSprite(sprites) instanceof Block)) {
					direction = Direction.UP_RIGHT;
				} else if (direction == Direction.DOWN_RIGHT
						&& (getSprite(sprites) instanceof Platform || getSprite(sprites) instanceof Block)) {
					direction = Direction.UP_RIGHT;
				}

				// remove block
				for (Sprite sprite : sprites) {
					if (sprite instanceof Block) {
						Block block = (Block) sprite;
						block.remove(sprite);
					}
				}

			}
			if (direction == Direction.UP_RIGHT) {
				posX += moveX * deltaTime + this.runSpeed;
				posY -= moveY * deltaTime + this.runSpeed;
			} else if (direction == Direction.UP_LEFT) {
				posX -= moveX * deltaTime + this.runSpeed;
				posY -= moveY * deltaTime + this.runSpeed;
			} else if (direction == Direction.DOWN_LEFT) {
				posX -= moveX * deltaTime + this.runSpeed;
				posY += moveY * deltaTime + this.runSpeed;
			} else if (direction == Direction.DOWN_RIGHT) {
				posX += moveX * deltaTime + this.runSpeed;
				posY += moveY * deltaTime + this.runSpeed;
			} else if (direction == Direction.UP) {
				posY -= moveY * deltaTime + this.runSpeed;
			} else if (direction == Direction.DOWN) {
				posY += moveY * deltaTime + this.runSpeed;
			}
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
