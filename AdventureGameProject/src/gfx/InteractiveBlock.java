package gfx;

public class InteractiveBlock extends Block {

	public InteractiveBlock(int x, int y, int type, int function) {
		super(x, y, type);
		
		setFunction(function);
		
		toggleSolid(true);
		setInteractive(true);
		
		setInteractiveImage(function);
		
	}

}
