import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;

public class player implements KeyListener{
	
	public static double xval;
	
	public static Image player = Toolkit.getDefaultToolkit().createImage("player.png");
	boolean left = false;
	boolean right = false;
	boolean bulletShot = false;
	boolean bullet2Shot = false;
	boolean bullet3Shot = false;
	
	bullet a;
	bullet b;
	bullet c;
	public player(int x) {
		xval = x;
		
	}

	public void paint(Graphics g, ImageObserver io) {
		if(bulletShot) b.paint(g, io);
		if(bullet2Shot) a.paint(g, io);
		if(bullet3Shot) c.paint(g, io);
		g.drawImage(player, (int)xval-17, 600, 36, 32, io);
	}
	public void update() {
		if(left) {
			xval-=6;
		}
		if(right)xval+=6;
		if(bulletShot) {
			b.update();
			hits(b);
		}
		if(bullet2Shot) {
			a.update();
			hits(a);
		}
		if(bullet3Shot) {
			c.update();
			hits(c);
		}
	}
	
	public void hits(bullet d) {
		for(int i = 0; i<DenckerInvader.img.size(); i++) {
			if(d.getX()<=DenckerInvader.img.get(i).x+35 && d.getX()>=DenckerInvader.img.get(i).x && d.getY()>=enemy.y && d.getY()<=enemy.y+28) {
				DenckerInvader.img.remove(i);
				if(d.getX()==b.getX() && d.getY()==b.getY()) bulletShot=false;
				else if(d.getX()==a.getX() && d.getY()==a.getY()) bullet2Shot=false;
				else if(d.getX()==c.getX() && d.getY()==c.getY()) bullet3Shot=false;
				break;
			}
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode()==37) {
			left = true;
			if(xval-18<=0)left = false;
		}
		if(k.getKeyCode()==39) {
			right = true;
			if(xval+18>=1000)right = false;
		}
		if(k.getKeyCode()==32) {
			if(!bulletShot || b.getY()<=0) {
				b = new bullet((int) (xval));
				bulletShot = true;
				
			}else if(!bullet2Shot || a.getY()<=0) {
				a = new bullet((int) (xval));
				bullet2Shot = true;
				
			}else if(!bullet3Shot|| c.getY()<=0) {
				c = new bullet((int) (xval));
				bullet3Shot = true;
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		if(k.getKeyCode()==37)left = false;
		if(k.getKeyCode()==39)right = false;
	}

	@Override
	public void keyTyped(KeyEvent k) {
		
		
	}



}
