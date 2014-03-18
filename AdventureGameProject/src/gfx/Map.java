package gfx;

import game.Run;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Map {

	public Block[][] blocks;
	
	private Block lastBlockVer;
	private Block lastBlockHor;
	
	private int xStart, yStart, columns , rows;
	public int mapWidth;
	public int mapHeight;

	public GlobalMap globalMap;
	public int globalPosX = 0;
	public int globalPosY = 0;
	
	public boolean outOfPlaceHor = false;
	public boolean outOfPlaceVer = false;
	
	public Map(int x, int y) {
		xStart = x - Screen.blockSize;
		yStart = y - Screen.blockSize;
	}
	
	public void generateGlobalMap(String type){
		if(type.equals("JungleRuins")){
			globalMap = new JungleRuins();
		}
		
		else{
			
			globalMap = new GlobalMap();
			
		}
	}
	
	public void getMapReset(int mapId) {
		if (mapId == 1) { // Lille map
			globalPosX = 1;
			globalPosY = 0;
			xStart = Run.window.screen.width/2 - (Screen.blockSize * 5);
			yStart = Run.window.screen.height/2 - (Screen.blockSize * 4);
			outOfPlaceHor = false;
			outOfPlaceVer = false;
			Run.player.setPlayer(270, 125, true);
			getMap();
		}
		if (mapId == 2) { //Stort map (Main map) - kommer ud af lille map
			globalPosX = 0;
			globalPosY = 0;
			xStart = -480;
			yStart = -200;
			outOfPlaceHor = true;
			outOfPlaceVer = true;
			Run.player.setPlayer(450, 218, false);
			getMap();
		}
	}
	
	public void getMap(){		
		int x = xStart;
		int y = yStart;
		mapWidth = 0;
		mapHeight = 0;
		int doorCount = 0;
		int interactiveCount = 0;
		
		//Gets map from globalMap
		LocalMap blockTypes = globalMap.enterLocalMap(globalPosX , globalPosY);
		columns = blockTypes.x;
		rows	= blockTypes.y;
		
		blocks = new Block[rows][columns];
		
		for(int i = 0; i < blockTypes.y; i++){		
			x = xStart;
			
			for(int j = 0; j < blockTypes.x; j++){
			
				if(blockTypes.map[i][j] == 3 || blockTypes.map[i][j] == 14){
					
					blocks[i][j] = new DoorBlock(x , y , blockTypes.map[i][j], blockTypes.getDoorId(doorCount + 1), blockTypes.getDoorId(doorCount));
					doorCount++;
					
				} else if (blockTypes.map[i][j] == 13) {
					
					blocks[i][j] = new InteractiveBlock(x, y, blockTypes.getInteractiveId(interactiveCount), blockTypes.getInteractiveId(interactiveCount + 1));
					interactiveCount++;
					
				} else {
					
					blocks[i][j] = new Block(x , y , blockTypes.map[i][j]);
					
				}
				x += Screen.blockSize;

			}
			
			y += Screen.blockSize;
			
		}
		
		lastBlockVer = blocks[rows-1][0];
		lastBlockHor = blocks[rows-1][columns-1];
		
		mapWidth = x - Screen.blockSize;
		mapHeight = y - Screen.blockSize;
	}

	public boolean moveMap(String direction) {
		boolean movePlayer = false;		
		if (direction.equals("right")) {
			if (blocks[0][0].getBounds().x + Screen.blockSize < 2) {
				xStart += Run.player.getSpeed();	
			} else {
				movePlayer = true;
			}
		}
		if (direction.equals("left")) {
			if (lastBlockHor.getBounds().x + 6 > Run.window.screen.width) {			
				xStart -= Run.player.getSpeed();
			} else {
				movePlayer = true;
			}
		}
		if (direction.equals("up")) {
			if (lastBlockVer.getBounds().y + Screen.blockSize - 2 > Run.window.screen.height) {			
				yStart -= Run.player.getSpeed();
			} else {
				movePlayer = true;
			}
		}
		if (direction.equals("down")) {
			if (blocks[0][0].getBounds().y + Screen.blockSize < 2) {
				yStart += Run.player.getSpeed();
			} else {
				movePlayer = true;
			}
		}

		int x = xStart;
		int y = yStart;

		for (int i = 0; i < blocks.length; i++) {
			
			x = xStart;
			
			for(int j = 0; j < blocks[i].length; j++){
				
				blocks[i][j].setBounds(x, y);
				
				x += Screen.blockSize;
				
			}
			
			y += Screen.blockSize;
			
		}

		if (xStart != 0 - Screen.blockSize) {
			outOfPlaceHor = true;
		} else {
			outOfPlaceHor = false;
		}
		if (yStart != 0 - Screen.blockSize) {
			outOfPlaceVer = true;
		} else {
			outOfPlaceVer = false;
		}
		return movePlayer;
	}

	public void paint(Graphics g2) {
		for (int i = 0; i < blocks.length; i++) {
			
			for(int j = 0; j < blocks[i].length; j++){
				
				int x = blocks[i][j].getBounds().x;
				int y = blocks[i][j].getBounds().y;
				
				ArrayList<Image> currentImages = blocks[i][j].getImages();
				
				if(currentImages == null){
					
					g2.setColor(blocks[i][j].getColor());
					g2.fillRect(blocks[i][j].getBounds().x, blocks[i][j].getBounds().y, Screen.blockSize,
							Screen.blockSize);
				
				} else{
					
					for(int n = 0; n < currentImages.size(); n++){
					
						g2.drawImage(currentImages.get(n) , x , y , Screen.blockSize , Screen.blockSize , null);
					
					}
				}	
				
			}
		}
	}
}
