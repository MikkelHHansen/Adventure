package gfx;

import java.awt.Rectangle;

public class DoorBlock extends Block {
	
	private Rectangle doorBounds;
	
	private int direction;
	
	public DoorBlock(int x, int y, int type, int direction, int roomPointer) {
		super(x, y, type);
		
		if (direction == 1) {
			doorBounds = new Rectangle(getBoundsDoor().x, getBoundsDoor().y, getBoundsDoor().width, getBoundsDoor().height);
		}
		if (direction == 2) {
			doorBounds = new Rectangle(getBoundsDoor().x, getBoundsDoor().y, getBoundsDoor().width - 20, getBoundsDoor().height);
		}
		if (direction == 3) {
			doorBounds = new Rectangle(getBoundsDoor().x, getBoundsDoor().y, getBoundsDoor().width, getBoundsDoor().height - 20);
		}

		this.direction = direction;
		
		toggleDoor(true);
		
		setRoomPointer(roomPointer);
	}
	
	public Rectangle getBounds() {
		return doorBounds;
	}
	
	public void setBounds(int x, int y) {
		setBoundsDoor(x, y);
		if (direction == 1) {
			doorBounds.x = x;
			doorBounds.y = y;
		}
		if (direction == 2 || direction == 3) {
			doorBounds.x = x;
			doorBounds.y = y;
		}
	}
	
	public boolean isLocked() {
		return isSolid();
	}
	
	public void unlock() {
		toggleSolid(false);
	}
	
	public void lock() {
		toggleSolid(true);
	}
	
}
