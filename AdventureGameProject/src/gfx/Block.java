package gfx;

import game.Run;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Block {
	
	private Rectangle bounds;
	
	private Color color;
	private ArrayList<Image> images = new ArrayList<Image>();
	private int size = Screen.blockSize;
	
	private boolean solid;
	
	private boolean door = false;
	
	private boolean interactive = false;
	private boolean active = false;
	private int function;
	
	private int roomPointer;
	
	public Block(int x, int y, int type) {

		bounds = new Rectangle(x, y, size, size);
		
		images.add(Sprites.backgroundTiles[type]);
		if(type == 3){
			
			images.add(Sprites.overlayTiles[2]);
			
		}
		
		else if(type == 14){
			
			images.add(Sprites.overlayTiles[1]);
			
		}
		
		//is solid block?
		if (type == 2 || type == 0 || type == 11) {
			this.solid = true;
			this.color = Color.black;
		} 
		
	}
		
	// Interactive block features ---
	public void setInteractiveImage(int val) {
		if (val == 0) {
			images.add(Sprites.overlayTiles[3]);
		}
	}
	
	public void setFunction(int value) {
		function = value;
	}
	
	public void toggleActive(boolean val) {
		active = val;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void doAction() {
		if (active) {
			if (function == 0) { // åben kiste - TODO Chest will need an ID referring to the database
				Run.window.screen.screenMsg.showMessage("Åbner kiste");
				System.out.println("Åbner kiste");
			}
		}
	}
	
	public void reverseAction() {
		if (active) {
			if (function == 0) { // lukker kiste
				Run.window.screen.screenMsg.showMessage("Lukker kiste");
				System.out.println("lukker kiste");
			}
		}
	}	
	
	public void setInteractive(boolean toggle) {
		interactive = toggle;
	}
	
	public boolean isInteractive() {
		return interactive;
	}
	//Interactive block ---
	
	public void setRoomPointer(int value) {
		roomPointer = value;
	}
	
	public int getRoomPointer() {
		return roomPointer;
	}

	public void toggleSolid(boolean value) {
		this.solid = value;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public void toggleDoor(boolean value) {
		this.door = value;
	}
	
	public boolean isDoor() {
		return door;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public Rectangle getBoundsDoor() {
		return bounds;
	}
	
	public void setBoundsDoor(int x, int y) {
		bounds.x = x;
		bounds.y = y;
	}
	
	public void setBounds(int x, int y) {
		bounds.x = x;
		bounds.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public ArrayList<Image> getImages(){
		
		return images;
		
	}
	
}