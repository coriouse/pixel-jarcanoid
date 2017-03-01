package app.pixel.jarcanoid.arena;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import app.pixel.jarcanoid.object.Sprite;

public class Arena {
	public static Arena currentWorld = null;

	private static long lastTime = System.nanoTime();

	public List<Sprite> spites = new ArrayList<Sprite>();
	public List<Sprite> addSpites = new ArrayList<Sprite>();
	public List<Sprite> removeSpites = new ArrayList<Sprite>();

	private static BufferedImage backdrop = null;

	private static int backdropX = 0;

	public static void update() {

		float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
		lastTime = System.nanoTime();
		for (Sprite sprite : currentWorld.spites) {
			sprite.update(deltaTime);
		}

		for (Sprite sprite : currentWorld.addSpites) {
			if (!currentWorld.spites.contains(sprite)) {
				currentWorld.spites.add(sprite);
			}
		}

		currentWorld.addSpites.clear();

		for (Sprite sprite : currentWorld.removeSpites) {
			if (currentWorld.spites.contains(sprite)) {
				currentWorld.spites.remove(sprite);
			}
		}

		currentWorld.removeSpites.clear();
	}

	public static void render(Graphics g) {
		for (Sprite sprite : currentWorld.spites) {
			sprite.render(g);
		}
	}

	public void addSprite(Sprite sprite) {
		if (!addSpites.contains(sprite)) {
			addSpites.add(sprite);
		}
	}

	public void removeSprite(Sprite sprite) {
		if (!removeSpites.contains(sprite)) {
			removeSpites.add(sprite);
		}
	}

}
