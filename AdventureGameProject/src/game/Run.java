package game;

import entities.Player;
import gfx.Window;

public class Run{
	
	public static final String TITLE = "Adventure Game Alpha 0.06";
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	public static boolean running = false;
	public static boolean gameStarted = false;
	public static boolean gamePaused = false;
	
	public static Window window;
	
	public static Player player;
	
	public static void main(String[] args){
		init();			
		window.startGame();	
	}
	
	public static void init() {
		
		player = new Player(125, 100);
		player.initSideBounds();
		
		window = new Window(TITLE, WIDTH, HEIGHT);
	}
}