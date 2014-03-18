package gfx;
import game.*;


import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable{
	
	public Screen screen;
	private Thread gameLoop;
	private InputHandler input;
	private Fps fps = new Fps();
	
	public Window(String title, int width, int height) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(title);
		
		screen = new Screen(width, height);
		add(screen, BorderLayout.CENTER);
		
		input = new InputHandler();
		addKeyListener(input);

		addMouseMotionListener(new MouseMotListener());
		addMouseListener(new MouseClickListener());
		
		setVisible(true);
	}
	
	public void startGame() {
		gameLoop = new Thread(this);
		gameLoop.start();
		Run.running = true;
		
		new Thread(fps).start();
		
		System.out.println("running");
	}
	
	public void stopGame() {
		try {
			gameLoop.join();
			Run.running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {	
		while(Run.running){	
			try {
				screen.update();
				screen.paint();
				fps.fpsPlus();
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}