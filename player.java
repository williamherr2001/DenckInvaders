import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

public class player implements KeyListener{
	
	public static double xval;
	double width;
	double height;
	public static Image player = Toolkit.getDefaultToolkit().createImage("player.png");
	boolean keypress = false;
	public player(int x) {
		xval = x;
		
	}

	public void paint(Graphics g, ImageObserver io) {
		g.drawImage(player, (int)xval-18, 668, 36, 32, io);
	}
	public void update() {
		if(keypress) {
			
		}
	}
	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode()==KeyEvent.VK_LEFT) {
			if(xval-18>=0)xval-=3;
		}
		keypress = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		keypress = false;
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}



}
