package game;

import gfx.Screen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickListener implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Start menu
		if (Screen.startMenu.hoveringStart) {
			Run.gameStarted = true;
		}
		
		if(Screen.startMenu.hoveringOptions) {
			
		}
		
		if (Screen.startMenu.hoveringExit) {
			System.exit(1);
		}
		
		//Pause menu
		if (Screen.pauseMenu.hoveringResume) {
			Run.gamePaused = false;
		}
		
		if(Screen.startMenu.hoveringOptions) {
			
		}
		
		if (Screen.pauseMenu.hoveringExit) {
			System.exit(1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
