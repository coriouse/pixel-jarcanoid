package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.graphic.Render;

public class Ground extends Base {

	public Ground(float posX, float posY, int width, int height) {
		super(posX, posY, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ground []";
	}
	
	public void render(Graphics g) {
		//TODO transparacy
		g.drawRect((int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2, (int)this.width, (int)this.height);
	}

}
