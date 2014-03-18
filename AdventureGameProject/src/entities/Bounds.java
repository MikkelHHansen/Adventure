package entities;

import game.Run;

import java.awt.Rectangle;

public class Bounds {
	
	//This class is used for collision detection 
	
	private Rectangle left, right, up, down;
	
	public Bounds() {
		left = new Rectangle(Run.player.getBounds().x - 2, Run.player.getBounds().y, 2, Run.player.getBounds().height);
		right = new Rectangle(Run.player.getBounds().x + Run.player.getBounds().width, Run.player.getBounds().y, 2, Run.player.getBounds().height);
		up = new Rectangle(Run.player.getBounds().x, Run.player.getBounds().y - 2, Run.player.getBounds().width, 2);
		down = new Rectangle(Run.player.getBounds().x, Run.player.getBounds().y + Run.player.getBounds().height, Run.player.getBounds().width, 2);
	}
	
	public void update() {
		left.x = Run.player.getBounds().x - 2;
		left.y = Run.player.getBounds().y;
		
		right.x = Run.player.getBounds().x + Run.player.getBounds().width;
		right.y = Run.player.getBounds().y;
		
		up.x = Run.player.getBounds().x;
		up.y = Run.player.getBounds().y - 2;
		
		down.x = Run.player.getBounds().x;
		down.y = Run.player.getBounds().y + Run.player.getBounds().height;
	}
	
	public Rectangle getBounds(String side) {
		if (side.equals("left")) {
			return left;
		}
		if (side.equals("right")) {
			return right;
		}
		if (side.equals("up")) {
			return up;
		}
		if (side.equals("down")) {
			return down;
		} else {
			System.out.println("ERROR IN GETTING PLAYERBOUNDS: SIDE NOT SPECIFIED CORRECTLY");
			return new Rectangle(0, 0, 1, 1);
		}
	}
	
}
