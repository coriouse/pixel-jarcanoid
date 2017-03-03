package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.graphic.Render;

public class Base extends Sprite {

	int x1, y1, x2, y2;

	public Base(float posX, float posY, int x1, int y1, int x2, int y2) {
		super(posX, posY);

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}

	public void update(float deltaTime) {
		// render stuff
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);	
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
}
