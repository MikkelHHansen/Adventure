package gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScreenMessage {
	
	private int showMessageCount = 0;
	private int showMessage = 75;
	
	private boolean showingMessage = false;
	
	private String message;
	
	private Font font = new Font("helvetica", 2, 15);
	
	public ScreenMessage() {
		
	}
	
	public void showMessage(String msg) {
		showMessageCount = 0;
		
		showingMessage = true;
		
		message = msg;
	}
	
	public void paint(Graphics g) {
		if (showingMessage) {
			if (showMessageCount <= showMessage) {
				g.setColor(Color.WHITE);
				g.setFont(font);
				g.drawString(message, 25, 350);
				showMessageCount++;
			} else {
				showingMessage = false;
			}
		}
	}
	
}
