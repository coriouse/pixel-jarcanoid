package app.pixel.jarcanoid.game;

import app.pixel.jarcanoid.arena.Arena;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.object.WallLeft;
import app.pixel.jarcanoid.object.WallRight;
import app.pixel.jarcanoid.object.Ball;
import app.pixel.jarcanoid.object.Ground;
import app.pixel.jarcanoid.object.Platform;
import app.pixel.jarcanoid.object.Proof;

public class Game {

	public static void main(String[] args) {
		Render.init();

		Arena.currentWorld = new Arena();
		//Platform
		Arena.currentWorld.addSprite(new Platform(0, 200, 100, 20));
		//Walls
		Arena.currentWorld.addSprite(
				new WallRight(390 , 5, 5, Render.gameHeight - 35));
		Arena.currentWorld.addSprite(new WallLeft(-390, 5, 5,  Render.gameHeight - 35));
		//Proof
		Arena.currentWorld.addSprite(new Proof(0,-200, Render.gameWidth-20, 5));
		//Ground
		Arena.currentWorld.addSprite(new Ground(0, 215, Render.gameWidth-15, 5));
		
		//Ball
		Arena.currentWorld.addSprite(new Ball(45, 200, 100, 40));
					
		//blocks
		//blcok stuff
	}

	public static void quit() {
		System.exit(1);
	}

}
