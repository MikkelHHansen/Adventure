package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	public void keyTyped(KeyEvent e) {	
	}

	public void keyPressed(KeyEvent e) {
		//Moving
		if (!Run.gamePaused && Run.gameStarted) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				Run.player.movingLeft = true;
			} 
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				Run.player.movingRight = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				Run.player.movingUp = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				Run.player.movingDown = true;
			}
				
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
				Run.player.running = false;
			}
			//Moving
			
			//Interacting
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Run.player.interact();
			}
			//Interacting
		}
		
		//Game Control
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (!Run.gamePaused && Run.gameStarted) {
				Run.gamePaused = true;
			} else {
				Run.gamePaused = false;
			}
		}
		//
	}

	public void keyReleased(KeyEvent e) {
		if (!Run.gamePaused && Run.gameStarted) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				Run.player.movingLeft = false;
				if (!Run.gamePaused) Run.player.setAnimationToStartNextMove("left");
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				Run.player.movingRight = false;
				if (!Run.gamePaused) Run.player.setAnimationToStartNextMove("right");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				Run.player.movingUp = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				Run.player.movingDown = false;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
				Run.player.running = true;
			}
		}
	}
}