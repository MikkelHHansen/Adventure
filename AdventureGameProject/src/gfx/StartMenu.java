package gfx;

import game.MouseMotListener;
import game.Run;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StartMenu {
	
	private String startGameText = "Start game";
	private String optionsText = "Options";
	private String exitGameText = "Exit game";
	
	private Rectangle startGame, options, exitGame;
	public boolean hoveringStart, hoveringOptions, hoveringExit;
	
	private Font titleFont = new Font("Georgia", 3, 25);
	private Font buttonFont = new Font("Copperplate Gothic Light", 0, 15);
	
	public StartMenu() {
		startGame = new Rectangle(485, 225, 150, 20);
		options = new Rectangle(485, 275, 150, 20);
		exitGame = new Rectangle(485, 325, 150, 20);
	}
	
	public void update() {
		if (startGame.contains(MouseMotListener.mouse)) {
			hoveringStart = true;
		} else {
			hoveringStart = false;
		}
		
		if (options.contains(MouseMotListener.mouse)) {
			hoveringOptions = true;
		} else {
			hoveringOptions = false;
		}
		
		if (exitGame.contains(MouseMotListener.mouse)) {
			hoveringExit = true;
		} else {
			hoveringExit = false;
		}
	}
	
	public void paint(Graphics g) {
		//Background
		g.setColor(Color.black);
		g.fillRect(0, 0, Run.window.getWidth(), Run.window.getHeight());
		//
		
		//Title
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString(Run.TITLE, 50, 50);
		//
		
		//Buttons
		g.setFont(buttonFont);
			
		if (!hoveringStart) {
			g.setColor(Color.gray);
		} else {
			g.setColor(Color.white);
		}	
		g.drawString(startGameText, startGame.x, startGame.y - 10);
		
		if (!hoveringOptions) {
			g.setColor(Color.gray);
		} else {
			g.setColor(Color.white);
		}	
		g.drawString(optionsText, options.x, options.y - 10);
		
		if (!hoveringExit) {
			g.setColor(Color.gray);
		} else {
			g.setColor(Color.white);
		}
		g.drawString(exitGameText, exitGame.x, exitGame.y - 10);
		
		//
	}
	
}
