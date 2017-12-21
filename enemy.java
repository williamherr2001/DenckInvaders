import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
public class enemy {
	
	public double x;
	static double y;
	static double vx=10;
	int index;
	public static int maxSize = 12;
	public static Image bug =Toolkit.getDefaultToolkit().createImage("invader.jpg");
	public enemy(int x, int y, int size) {
		this.x = x;
		enemy.y = y;
		this.index = size;
	}
	public void paint(Graphics g, ImageObserver io) {
		g.drawImage(bug, (int)this.x, (int)enemy.y, 35, 28, io);
	}
	public void update() {
		
		if(x>=45*index+450||x<(45*index)+10) {
			if(x>=45*index+450) {
				vx=-Math.abs(vx);
				y+=35.0/12;
			} else if(x<45*index+10) {
				vx=Math.abs(vx);
				y+=35.0/12;
			}
			
		}
		
		x +=vx;
		
		
		
	}
	
	

}
