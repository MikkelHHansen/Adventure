package gfx;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprites {

	public static Image[] backgroundTiles = new Image[20];
	public static Image[] overlayTiles = new Image[5];
	
	public static Image[] playerSprites = new Image[20];
	
	public static void loadImages(String environmentType){
		
		//Void. It's grass for now.
		backgroundTiles[0] = new ImageIcon("res/sprites/" + environmentType + "/floor.png").getImage(); //grass void
		
		backgroundTiles[1] = new ImageIcon("res/sprites/" + environmentType + "/floor.png").getImage();
		backgroundTiles[2] = new ImageIcon("res/sprites/" + environmentType + "/wall.png").getImage();
		backgroundTiles[3] = new ImageIcon("res/sprites/" + environmentType + "/wall.png").getImage();
		backgroundTiles[4] = new ImageIcon("res/sprites/" + environmentType + "/road.png").getImage();
		backgroundTiles[5] = new ImageIcon("res/sprites/" + environmentType + "/roadVertical.png").getImage();
		backgroundTiles[6] = new ImageIcon("res/sprites/" + environmentType + "/roadVerticalU.png").getImage();
		backgroundTiles[7] = new ImageIcon("res/sprites/" + environmentType + "/roadVerticalD.png").getImage();
		backgroundTiles[8] = new ImageIcon("res/sprites/" + environmentType + "/roadHorizontal.png").getImage();
		backgroundTiles[9] = new ImageIcon("res/sprites/" + environmentType + "/roadHorizontalL.png").getImage();
		backgroundTiles[10] = new ImageIcon("res/sprites/" + environmentType + "/roadHorizontalR.png").getImage();
		backgroundTiles[12] = new ImageIcon("res/sprites/" + environmentType + "/bricks.png").getImage(); //type 11 = void - so 12
		
		overlayTiles[0] = new ImageIcon("res/sprites/overlays/mild shadow.png").getImage();
		overlayTiles[1] = new ImageIcon("res/sprites/overlays/door.png").getImage();
		overlayTiles[2] = new ImageIcon("res/sprites/overlays/doorUp.png").getImage();
		overlayTiles[3] = new ImageIcon("res/sprites/overlays/chest.png").getImage();
		overlayTiles[4] = new ImageIcon("res/sprites/overlays/doorLocked.png").getImage();
		
		playerSprites[0] = new ImageIcon("res/sprites/player/Right1.png").getImage();
		playerSprites[1] = new ImageIcon("res/sprites/player/Right2.png").getImage();
		playerSprites[2] = new ImageIcon("res/sprites/player/Right3.png").getImage();
		playerSprites[3] = new ImageIcon("res/sprites/player/Left1.png").getImage();
		playerSprites[4] = new ImageIcon("res/sprites/player/Left2.png").getImage();
		playerSprites[5] = new ImageIcon("res/sprites/player/Left3.png").getImage();
		playerSprites[6] = new ImageIcon("res/sprites/player/front1.png").getImage();
		playerSprites[7] = new ImageIcon("res/sprites/player/front2.png").getImage();
		playerSprites[8] = new ImageIcon("res/sprites/player/front3.png").getImage();
		playerSprites[9] = new ImageIcon("res/sprites/player/Back1.png").getImage();
		playerSprites[10] = new ImageIcon("res/sprites/player/Back2.png").getImage();
		playerSprites[11] = new ImageIcon("res/sprites/player/Back3.png").getImage();
		
	}
}
