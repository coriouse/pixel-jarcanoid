package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.glass.events.KeyEvent;

import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.input.Input;

public class Platform extends Mob {
	// TODO Enum PlatformDirection
	public static int platfomDirection = 1; // 1 - right, 0 - left

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
			platfomDirection = 0;
		}
		if (Input.getKey(KeyEvent.VK_RIGHT)) {
			moveX += runSpeed;
			platfomDirection = 1;
		}

		posX += moveX;

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
