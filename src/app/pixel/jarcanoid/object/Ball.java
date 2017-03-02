package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.graphic.Render;

public class Ball extends Mob {

	private float radius = 10f;

	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
	
	}

	public void update(float deltaTime) {
		// render
	}

	public void render(Graphics g) {
		int x = 100;
		int y = 100;
		g.setColor(Color.green);
		g.fillOval(((int) (posX - width / 2) + Render.gameWidth / 2) - (int) radius, 
				((int) (posY - height / 2) + Render.gameHeight / 2) - (int) radius, 
		(int) radius * 2, 
		(int) radius * 2);

	}
}
