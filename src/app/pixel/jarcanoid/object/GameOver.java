package app.pixel.jarcanoid.object;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.glass.events.KeyEvent;

import app.pixel.jarcanoid.game.Game;
import app.pixel.jarcanoid.graphic.Render;
import app.pixel.jarcanoid.input.Input;
/**
 * 
 * @author Sergei_Ogarkov
 *
 */
public class GameOver extends Sprite {

	public GameOver(float posX, float posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	

	public void update(float deltaTime) {
		if (Input.getKey(KeyEvent.VK_ENTER)) {
			Game.gameOver();
			Game.startGame();
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
	    g.setFont(g.getFont().deriveFont(45f));
	    g.drawString("GAME OVER", (int) (posX - width / 2) + Render.gameWidth / 2, (int) (posY - height / 2) + Render.gameHeight / 2);	    
	    g.setColor(Color.gray);
	    g.setFont(g.getFont().deriveFont(20f));
	    g.drawString("Please press <Enter>", (int) ((posX - width / 2) + Render.gameWidth / 2)+35, (int) ((posY - height / 2) + Render.gameHeight / 2)+25);
			    
	}

	@Override
	public String toString() {
		return "GameOver []";
	}

}
