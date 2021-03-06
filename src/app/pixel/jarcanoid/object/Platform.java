package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.glass.events.KeyEvent;

import app.pixel.jarcanoid.game.Direction;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.input.Input;
/**
 * 
 * @author Sergei_Ogarkov
 *
 */
public class Platform extends Mob {

	public static Direction direction = Direction.FREE;

	public Platform(float posX, float posY, float width, float height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		runSpeed = 10.0f;

	}

	public void update(float deltaTime) {

		float moveX = 0;

		if (Input.getKey(KeyEvent.VK_LEFT)) {
			moveX -= runSpeed;
			direction = Direction.LEFT;
		}
		if (Input.getKey(KeyEvent.VK_RIGHT)) {
			moveX += runSpeed;
			direction = Direction.RIGHT;
		}
		posX += moveX;

		// Defined of border game
		Sprite[] sprites = getColliders(posX, posY);
		if (sprites.length > 0) {
			for (Sprite sprite : sprites) {
				if (sprite instanceof WallLeft) {
					posX += runSpeed;
				} else if (sprite instanceof WallRight) {
					posX -= runSpeed;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(new Color(110, 70, 40));
		g.fillRect((int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2,
				(int) width, (int) height);
	}

	@Override
	public String toString() {
		return "Platform []";
	}
}
