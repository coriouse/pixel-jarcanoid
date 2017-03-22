package app.pixel.jarcanoid.game;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.object.WallLeft;
import app.pixel.jarcanoid.object.WallRight;
import app.pixel.jarcanoid.object.Ball;
import app.pixel.jarcanoid.object.Block;
import app.pixel.jarcanoid.object.GameOver;
import app.pixel.jarcanoid.object.Score;
import app.pixel.jarcanoid.object.Ground;
import app.pixel.jarcanoid.object.Platform;
import app.pixel.jarcanoid.object.Proof;
import app.pixel.jarcanoid.object.Lifes;

public class Game {

	private final static int WIDTH_WALLS = 2;
	private final static int WIDTH_BLOCK = 80;
	private final static int HEIGHT_BLOCK = 20;

	public static void main(String[] args) {
		Render.init();

		Arena.currentWorld = new Arena();
		// Platform
		Arena.currentWorld.addSprite(new Platform(0, 200, 100, 20));

		// Walls
		Arena.currentWorld.addSprite(new WallRight(390, 5, WIDTH_WALLS, Render.gameHeight - 35));
		Arena.currentWorld.addSprite(new WallLeft(-390, 5, WIDTH_WALLS, Render.gameHeight - 35));
		// Proof
		Arena.currentWorld.addSprite(new Proof(0, -202, Render.gameWidth - 20, WIDTH_WALLS));
		// Ground
		Arena.currentWorld.addSprite(new Ground(0, 230, Render.gameWidth + 200, 1));

		// Ball
		Arena.currentWorld.addSprite(new Ball(45, 200, 100, 40));

		// blocks
		//LEVEL 1
		
		// 1 row
		Arena.currentWorld.addSprite(new Block(0, -150, WIDTH_BLOCK, HEIGHT_BLOCK, 0));
		Arena.currentWorld.addSprite(new Block(90, -150, WIDTH_BLOCK, HEIGHT_BLOCK, 1));
		Arena.currentWorld.addSprite(new Block(-90, -150, WIDTH_BLOCK, HEIGHT_BLOCK, 2));
		Arena.currentWorld.addSprite(new Block(-180, -150, WIDTH_BLOCK, HEIGHT_BLOCK, 3));
		Arena.currentWorld.addSprite(new Block(180, -150, WIDTH_BLOCK, HEIGHT_BLOCK, 4));
		// 2 row
		Arena.currentWorld.addSprite(new Block(0, -120, WIDTH_BLOCK, HEIGHT_BLOCK, 5));
		Arena.currentWorld.addSprite(new Block(90, -120, WIDTH_BLOCK, HEIGHT_BLOCK, 6));
		Arena.currentWorld.addSprite(new Block(-90, -120, WIDTH_BLOCK, HEIGHT_BLOCK, 7));
		Arena.currentWorld.addSprite(new Block(-180, -120, WIDTH_BLOCK, HEIGHT_BLOCK, 8));
		Arena.currentWorld.addSprite(new Block(180, -120, WIDTH_BLOCK, HEIGHT_BLOCK, 9));
		
		
		Arena.currentWorld.addSprite(new Lifes(-330, 220, 90, 20));
		Arena.currentWorld.addSprite(new Lifes(-310, 220, 90, 20));
		Arena.currentWorld.addSprite(new Lifes(-290, 220, 90, 20));
		
		Arena.currentWorld.addSprite(new Score(-270, 225));
		
		//game over
	//	Arena.currentWorld.addSprite(new GameOver(-130,0));

	}
	
	public static void gameOver() {
		Arena.currentWorld.cleanSprites();
	}

	public static void quit() {
		System.exit(1);
	}

}
