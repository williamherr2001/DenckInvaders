import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class bullet {
	public int xc;
	public int y;
	public static Image shot = Toolkit.getDefaultToolkit().createImage("bullet.png");
	public bullet(int x) {
		xc = x;
		y=600; 
	}
	
	public void paint(Graphics g, ImageObserver io) {
		g.drawImage(shot, this.xc, this.y, 6, 9, io);
	}
	public void update() {
		y-=20;
	}
	public int getX() {
		return xc;
	}
	public int getY() {
		return y;
	}
}
