package app.pixel.jarcanoid.game;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.object.Wall;
import app.pixel.jarcanoid.object.Platform;

public class Game {

	public static void main(String[] args) {
		Render.init();

		Arena.currentWorld = new Arena();
		Arena.currentWorld.addSprite(new Platform(0, 200, 100, 20));

		// Walls
		Arena.currentWorld
				.addSprite(new Wall(0, 0, Render.gameWidth - 10, 10, Render.gameWidth - 10, Render.gameHeight - 10));
		
		Arena.currentWorld
		.addSprite(new Wall(0, 0, 10, 10, 10, Render.gameHeight - 10));

	}

	public static void quit() {
		System.exit(1);
	}

}
