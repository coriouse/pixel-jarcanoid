package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.graphic.Render;
/**
 * 
 * @author Sergei_Ogarkov
 *
 */
public class Base extends Sprite {

	public Base(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;

	}

	public void update(float deltaTime) {
		//
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);	
		g.fillRect((int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2, (int)this.width, (int)this.height);
	}
}
