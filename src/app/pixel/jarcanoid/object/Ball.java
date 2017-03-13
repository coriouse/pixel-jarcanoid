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
	private Direction direction = Direction.UP;

	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		this.runSpeed = 5.0f;

	}

	public void update(float deltaTime) {

		// TODO need to resolve direction of the ball
		Sprite[] sprites = getColliders(posX, posY);
		System.out.println("Platform.direction=[" + Platform.direction + "], direction=[" + direction + "],"
				+ Arrays.toString(sprites)+", posY="+posY);
		// up
		if (sprites.length > 0) {
			
		if(direction == Direction.UP && Platform.direction == Direction.FREE && getSprite(sprites) instanceof Proof) {
			direction = Direction.DOWN;
		} else if(direction == Direction.DOWN && Platform.direction == Direction.FREE && getSprite(sprites) instanceof Platform) { 
			direction = Direction.UP;
		} else if(direction == Direction.UP_RIGHT && Platform.direction == Direction.RIGHT && getSprite(sprites) instanceof Proof) {
			direction = Direction.DOWN_RIGHT;
		} else if(direction == Direction.UP_RIGHT && Platform.direction == Direction.RIGHT && getSprite(sprites) instanceof WallRight) {
			direction = Direction.UP_LEFT;
		} 

		//	if (posY < 0) {
				/*if (direction == Direction.UP_RIGHT && ) {

					if (Platform.direction == Direction.RIGHT  && getSprite(sprites) instanceof Proof) {
						direction = Direction.DOWN_RIGHT;
					} else {
						direction = Direction.UP_LEFT;
					}
				} else if (direction == Direction.UP_LEFT) {
					if ((Platform.direction == Direction.LEFT)  && getSprite(sprites) instanceof Proof) {
						direction = Direction.DOWN_LEFT;
					} else {
						direction = Direction.UP_RIGHT;
					}
				}*/
		//	} else if (posY > 0) {
				// down
				 
				/*if (direction == Direction.DOWN_LEFT) {
					if (Platform.direction == Direction.LEFT && getSprite(sprites) instanceof Platform) {
						direction = Direction.UP_LEFT;
					} else {
						direction = Direction.DOWN_RIGHT;
					}
				} else if (direction == Direction.DOWN_RIGHT) {
					if (Platform.direction == Direction.RIGHT  && getSprite(sprites) instanceof Platform) {
						direction = Direction.UP_RIGHT;
					} else {
						direction = Direction.DOWN_LEFT;
					}
				}
			}*/
	//	}
		}
		if (direction == Direction.UP_RIGHT) {
			posX += moveX * deltaTime + this.runSpeed;
			posY -= moveY  * deltaTime + this.runSpeed;
		} else if (direction == Direction.UP_LEFT) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY -= moveY  * deltaTime + this.runSpeed;
		} else if (direction == Direction.DOWN_LEFT) {
			posX -= moveX * deltaTime + this.runSpeed;
			posY += moveY  * deltaTime + this.runSpeed;
		} else if (direction == Direction.DOWN_RIGHT) {
			posX += moveX * deltaTime + this.runSpeed;
			posY += moveY * deltaTime + this.runSpeed;
		} else if (direction == Direction.UP) {
			posY -= moveY  * deltaTime + this.runSpeed;
		} else if (direction == Direction.DOWN) {
			posY += moveY  * deltaTime + this.runSpeed;
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
