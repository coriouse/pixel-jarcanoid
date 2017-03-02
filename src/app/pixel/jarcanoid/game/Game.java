package app.pixel.jarcanoid.game;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.object.WallLeft;
import app.pixel.jarcanoid.object.WallRight;
import app.pixel.jarcanoid.object.Ball;
import app.pixel.jarcanoid.object.Platform;

public class Game {

	public static void main(String[] args) {
		Render.init();

		Arena.currentWorld = new Arena();
		//Platform
		Arena.currentWorld.addSprite(new Platform(0, 200, 100, 20));

		//Walls
		Arena.currentWorld.addSprite(
				new WallRight(0, 0, Render.gameWidth - 10, 10, Render.gameWidth - 10, Render.gameHeight - 10));
		Arena.currentWorld.addSprite(new WallLeft(0, 0, 10, 10, 10, Render.gameHeight - 10));
		//Ball
		Arena.currentWorld.addSprite(new Ball(45, 200, 100, 40));
		
		//blocks
		//blcok stuff
	}

	public static void quit() {
		System.exit(1);
	}

}
