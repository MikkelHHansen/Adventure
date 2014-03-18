package entities;

import game.Run;
import gfx.Block;
import gfx.Sprites;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	public int x;
	public int y;
	private int size = 28;
	private int speed = 1;
	public int facing = 0;
	
	private Rectangle bounds;
	private Bounds sideBounds; //Used for collision detection
	
	public boolean movingUp = false;
	public boolean movingDown = false;
	public boolean movingRight = false;
	public boolean movingLeft = false;
	public boolean running = true;
	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveRight = false;
	private boolean moveLeft = false;
	
	public boolean inside = false;
	
	public boolean isInteracting = false;
	
	private int animationShiftCount = 0;
	private int animationShift = 10;
	private int drawImage = 2;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		
		bounds = new Rectangle(x, y, size, size);
	}
	
	public void initSideBounds() {
		sideBounds = new Bounds();
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void update() {
		collisionDetection();
		
		move();
		
		sideBounds.update();
	}
	
	// USED FOR ANIMATING WALK 	
	public void updateImage() {
		if (facing == 0) {
			toggleImage(4);
		}
		if (facing == 1) {
			toggleImage(1);
		}
		if (facing == 2) {
			toggleImage(3);
		}
		if (facing == 3) {
			toggleImage(2);
		}	
		
	}

	public void setAnimationToStartNextMove(String direction) {
		animationShiftCount = 50;
		if (direction.equals("right")) {
			drawImage = 1;
		}
		if (direction.equals("left")) {
			drawImage = 7;
		}
	}
	
	public void toggleImage(int id) {
		if (id == 1) {
			if (animationShiftCount >= animationShift) {
				if (drawImage == 0) {
					drawImage = 1;
				} else if (drawImage == 1){
					drawImage = 2;
				} else if (drawImage == 2) {
					drawImage = 3;
				} else {
					drawImage = 0;
				}
				animationShiftCount = 0;
			} else {
				animationShiftCount++;
			}
			if (!moveRight) {
				drawImage = 1;
			}
		} else if (id == 2){
			if (animationShiftCount >= animationShift) {
				if (drawImage == 4) {
					drawImage = 5;
				} else if (drawImage == 5){
					drawImage = 6;
				} else if (drawImage == 6) {
					drawImage = 7;
				} else {
					drawImage = 4;
				}
				animationShiftCount = 0;
			} else {
				animationShiftCount++;
			}
			if (!moveLeft) {
				drawImage = 7;
			}
		} else if (id == 3) {
			if (animationShiftCount >= animationShift) {
				if (drawImage == 8) {
					drawImage = 9;
				} else if (drawImage == 9){
					drawImage = 10;
				} else if (drawImage == 10) {
					drawImage = 11;
				} else {
					drawImage = 8;
				}
				animationShiftCount = 0;
			} else {
				animationShiftCount++;
			}
			if (!moveDown) {
				drawImage = 11;
			}
		} else {
			if (animationShiftCount >= animationShift) {
				if (drawImage == 12) {
					drawImage = 13;
				} else if (drawImage == 13){
					drawImage = 14;
				} else if (drawImage == 14) {
					drawImage = 15;
				} else {
					drawImage = 12;
				}
				animationShiftCount = 0;
			} else {
				animationShiftCount++;
			}
			if (!moveUp) {
				drawImage = 15;
			}
		}
	}
	//ANIMATING WALK --
	
	public void move() {	
		
		boolean outOfPlaceVer = Run.window.screen.getMap().outOfPlaceVer;
		boolean outOfPlaceHor = Run.window.screen.getMap().outOfPlaceHor;
		int height = Run.window.screen.height;
		int width  = Run.window.screen.width;
		
		if (running) {
			speed = 2;
			animationShift = 10;
		} else {
			speed = 1;
			animationShift = 15;
		}
		
		if (inside) {
			running = false;
		}
		
		if (moveUp) {
			boolean move = false;
			if(outOfPlaceVer && bounds.y + size < (height/2)) {
				move = Run.window.screen.getMap().moveMap("down");
			} else {
				bounds.y -= speed;
			}
			
			if (move) {
				bounds.y -= speed;
			}
		}
		if (moveDown) {
			boolean move = false;
			if (bounds.y > (height/2) - 25) {
				move = Run.window.screen.getMap().moveMap("up");
			} else {
				bounds.y += speed;
			}
			
			if (move) {
				bounds.y += speed;
			}
		}
		if (moveRight) {	
			boolean move = false;
			if (bounds.x > (width/2) - 17) {
				move = Run.window.screen.getMap().moveMap("left");
			} else {
				bounds.x += speed;
			}
			
			if (move) {
				bounds.x += speed;
			}
		}
		if (moveLeft) {	
			boolean move = false;
			if(outOfPlaceHor && bounds.x + size < (width/2)) {
				move = Run.window.screen.getMap().moveMap("right");
			} else {
				bounds.x -= speed;
			}
			
			if (move) {
				bounds.x -= speed;
			}
		}
		
		updateImage();
		
		if (Run.gamePaused) {
			movingLeft = false;
			movingRight = false;
			movingUp = false;
			movingDown = false;
		}
	}
	
	public void setPlayer(int x, int y, boolean inside) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
		this.inside = inside;
		if (!inside) {
			running = true;
		}
	}
	
	public void collisionDetection() {
		if (movingRight) {
			moveRight = true;
			facing = 1;
		} else {
			moveRight = false;
		}
		if (movingLeft) {
			moveLeft = true;
			facing = 3;
		} else {
			moveLeft = false;
		}
		if (movingUp) {
			moveUp = true;
			facing = 0;
		} else {
			moveUp = false;
		}
		if (movingDown) {
			moveDown = true;
			facing = 2;
		} else {
			moveDown = false;
		}
		
		if (isInteracting) {
			moveDown = false;
			moveUp = false;
			moveLeft = false;
			moveRight = false;
		}
		
		Block[][] blocks = Run.window.screen.getMap().blocks;
		
		for (int i = 0; i < blocks.length; i++) {		
			for(int j = 0; j < blocks[i].length; j++) {
				if (sideBounds.getBounds("right").intersects(blocks[i][j].getBounds())) {	
					if (blocks[i][j].isSolid()) {
						moveRight = false;
					}
					if (blocks[i][j].isDoor()) {
						Run.window.screen.getMap().getMapReset(blocks[i][j].getRoomPointer());
					}
					if (blocks[i][j].isInteractive()) {
						blocks[i][j].toggleActive(true);
					}
				}
				if (sideBounds.getBounds("left").intersects(blocks[i][j].getBounds())) {	
					if (blocks[i][j].isSolid()) {
						moveLeft = false;
					}
					if (blocks[i][j].isDoor()) {
						Run.window.screen.getMap().getMapReset(blocks[i][j].getRoomPointer());
					}
					if (blocks[i][j].isInteractive()) {
						blocks[i][j].toggleActive(true);
					}
				}
				if (sideBounds.getBounds("up").intersects(blocks[i][j].getBounds())) {	
					if (blocks[i][j].isSolid()) {
						moveUp = false;
					}
					if (blocks[i][j].isDoor()) {
						Run.window.screen.getMap().getMapReset(blocks[i][j].getRoomPointer());
					}
					if (blocks[i][j].isInteractive()) {
						blocks[i][j].toggleActive(true);
					}
				}
				if (sideBounds.getBounds("down").intersects(blocks[i][j].getBounds())) {	
					if (blocks[i][j].isSolid()) {
						moveDown = false;
					}
					if (blocks[i][j].isDoor()) {
						Run.window.screen.getMap().getMapReset(blocks[i][j].getRoomPointer());
					}
					if (blocks[i][j].isInteractive()) {
						blocks[i][j].toggleActive(true);
					}
				}	
			}
		}
	}
	
	public void interact() {
		Block[][] blocks = Run.window.screen.getMap().blocks;
		boolean noOneActive = true;
		for (int i = 0; i < blocks.length; i++) {		
			for(int j = 0; j < blocks[i].length; j++){
				if (blocks[i][j].isActive()) {
					noOneActive = false;
					if (isInteracting) {
						blocks[i][j].reverseAction();
						isInteracting = false;
					} else {
						blocks[i][j].doAction();
						isInteracting = true;
					}
				}
			}
		}
		if (noOneActive) {
			isInteracting = false; //Making sure player can walk if he somehow gets out of 
								   // active zone when still interacting. (if he runs and click space he can do that)
		}
	}
	
	public void paint(Graphics g) {
		if (drawImage == 0) {
			g.drawImage(Sprites.playerSprites[0], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 1) {	
			g.drawImage(Sprites.playerSprites[1], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 2) {
			g.drawImage(Sprites.playerSprites[2], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 3) {
			g.drawImage(Sprites.playerSprites[1], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 4) {
			g.drawImage(Sprites.playerSprites[3], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 5) {
			g.drawImage(Sprites.playerSprites[4], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 6) {
			g.drawImage(Sprites.playerSprites[5], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 7) {
			g.drawImage(Sprites.playerSprites[4], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 8) {
			g.drawImage(Sprites.playerSprites[6], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 9) {
			g.drawImage(Sprites.playerSprites[7], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 10) {
			g.drawImage(Sprites.playerSprites[8], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 11) {
			g.drawImage(Sprites.playerSprites[7], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 12) {
			g.drawImage(Sprites.playerSprites[9], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 13) {
			g.drawImage(Sprites.playerSprites[10], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 14) {
			g.drawImage(Sprites.playerSprites[11], bounds.x, bounds.y, size, size, null);
		} else if (drawImage == 15) {
			g.drawImage(Sprites.playerSprites[10], bounds.x, bounds.y, size, size, null);
		}
	} 
	
}