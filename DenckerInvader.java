import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DenckerInvader extends JComponent implements Runnable {

	
	static player one;
	static ArrayList<enemy> img;
	public DenckerInvader() {
		one = new player(500);
		img = new ArrayList<enemy>();
		for(int i = 0; i<enemy.maxSize; i++) {
			img.add(new enemy(45*i+10, 0, i));
		}	
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i<img.size();i++) {img.get(i).paint(g, this);}
		one.paint(g, this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dencker Invader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.add(new DenckerInvader());
		frame.getContentPane().setBackground(Color.black);
		
	}

	@Override
	public void run() {
		while(true) {
			for(int i = 0; i<enemy.maxSize;i++)img.get(i).update();
			if(enemy.y>700) {
				Thread.currentThread().interrupt();
				break;
			}
			repaint();
			try {
				Thread.sleep(50);
				one.update();
				Thread.sleep(50);
				one.update();
				Thread.sleep(50);
				one.update();
				Thread.sleep(50);
				one.update();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}