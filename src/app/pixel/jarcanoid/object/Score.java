package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.graphic.Render;

public class Score extends Sprite {
	
	public static int SCORE = 0;

	public Score(float posX, float posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void update(float deltaTime) {
		//
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Score: " + SCORE, (int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2);
	}

}
