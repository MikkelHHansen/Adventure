package gfx;

public class Fps implements Runnable{
	
	private int fps = 0;
	
	public void fpsPlus() {
		fps++;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Fps: " + fps);
				fps = 0;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
