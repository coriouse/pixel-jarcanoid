package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;



public class Board extends Sprite{

	public Board(float posX, float posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	

	public void update(float deltaTime) {
		//
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Score: "+Ball.SCORE, (int)posX, (int)posY);
	}

}
