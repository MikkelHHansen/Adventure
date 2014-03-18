package gfx;

import game.MouseMotListener;
import game.Run;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PauseMenu {
	
	private String pauseTitleText = "Game paused";
	
	private String resumeGameText = "Resume game";
	private String optionsText = "Options";
	private String exitGameText = "Exit game";
	
	private Rectangle resumeGame, options, exitGame;
	public boolean hoveringResume, hoveringOptions, hoveringExit;
	
	private Font titleFont = new Font("Georgia", 3, 25);
	private Font buttonFont = new Font("Copperplate Gothic Light", 0, 15);
	
	private Color background = new Color(0, 0, 100, 80);
	
	public PauseMenu() {
		resumeGame = new Rectangle(485, 225, 150, 20);
		options = new Rectangle(485, 275, 150, 20);
		exitGame = new Rectangle(485, 325, 150, 20);
	}
	
	public void update() {
		if (resumeGame.contains(MouseMotListener.mouse)) {
			hoveringResume = true;
		} else {
			hoveringResume = false;
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
		g.setColor(background);
		g.fillRect(0, 0, Run.window.getWidth(), Run.window.getHeight());
		//
		
		//Title
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString(pauseTitleText, 50, 50);
		//
		
		//Buttons
		g.setFont(buttonFont);
			
		if (!hoveringResume) {
			g.setColor(Color.white);
		} else {
			g.setColor(Color.black);
		}	
		g.drawString(resumeGameText, resumeGame.x, resumeGame.y - 10);
		
		if (!hoveringOptions) {
			g.setColor(Color.white);
		} else {
			g.setColor(Color.black);
		}	
		g.drawString(optionsText, options.x, options.y - 10);
		
		if (!hoveringExit) {
			g.setColor(Color.white);
		} else {
			g.setColor(Color.black);
		}
		g.drawString(exitGameText, exitGame.x, exitGame.y - 10);	
		//
	}
	
}
