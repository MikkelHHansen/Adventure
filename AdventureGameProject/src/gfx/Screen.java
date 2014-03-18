package gfx;
import game.Run;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel {

	public int width;
	public int height;

	private Map map;
	
	public static final int blockSize = 32;
	
	public ScreenMessage screenMsg = new ScreenMessage();
	
	public static StartMenu startMenu = new StartMenu();
	public static PauseMenu pauseMenu = new PauseMenu();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		map = new Map(0, 0);
		map.generateGlobalMap("JungleRuins");
		map.getMap();

	}
	
	public void setMap(String path) {
		map.getMap();
	}

	public void paintComponent(Graphics g) {
		//BlackBG - VOID; should not be seen.
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		//
		
		// Map
		map.paint(g);
		// --

		// Player
		Run.player.paint(g);
		// --
		
		// MENUS
			//Start menu
		if (!Run.gameStarted) startMenu.paint(g);
			//
			//Pause menu
		if (Run.gamePaused) pauseMenu.paint(g);
			//
		//
		
		// Screen messages
		screenMsg.paint(g);
		// --
	}
	
	public Map getMap() {
		return map;
	}

	public void update() {
		Run.player.update();
		
		if (!Run.gameStarted) startMenu.update();
		if (Run.gamePaused) pauseMenu.update();
	}
	
	public void paint() {
		repaint();
	}

}