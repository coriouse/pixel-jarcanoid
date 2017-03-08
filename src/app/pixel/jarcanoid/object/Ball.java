package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;


public class Ball extends Mob {

	private float radius = 10f;
	private float moveX = 0;
	private float moveY = 0;
	private int direction = 1; // 1 - right, -1 - left
	
	public Ball(float posX, float posY, int width, int height) {
		super(posX, posY);

		this.width = width;
		this.height = height;
		this.runSpeed = 1.0f;

	}

	public void update(float deltaTime) {
		
		
		posX += moveX * deltaTime + this.runSpeed;
		posY -= moveY * deltaTime + this.runSpeed;
		
		//TODO doesn't work
		System.out.println(doesCollide(posX, posY));
		
		
		//doesCollide(posX, posY);
	}

	public void render(Graphics g) {
		int x = 100;
		int y = 100;
		g.setColor(Color.green);

		g.fillOval(((int) (posX - width / 2) + Render.gameWidth / 2) - (int) radius,
				((int) (posY - height / 2) + Render.gameHeight / 2) - (int) radius, (int) radius * 2, (int) radius * 2);

	}
	
	public void changeDirection(int derection) {
		//TODO добавить enum Direction
		//TODO изменить на enum Direction.LEFT,...
		this.direction = direction;
	}
}
