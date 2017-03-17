package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;

public class Block extends Sprite {
	
	private int number;

	public Block(float posX, float posY, float width, float height, int number) {
		super(posX, posY);
		this.width = width;
		this.height = height;
		this.number = number;
		
	}

	public void update(float deltaTime) {
		
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2,
				(int) width, (int) height);
	}
	
	public void remove(Sprite sprite) {
		++Ball.SCORE;
		Arena.currentWorld.removeSprite(sprite);
	}

	@Override
	public String toString() {
		return "Block ["+this.number+"][posX="+posX+", posY="+posY+"]";
	}

}
