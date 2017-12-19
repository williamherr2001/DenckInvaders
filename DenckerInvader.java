
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DenckerInvader extends JComponent implements Runnable {
	
	Denck img;
	
	public DenckerInvader() {
		img = new Denck((700-157)/2,(700-157)/2);
		Thread t = new Thread(this);
		
		t.start();
	}
	
	public void paint(Graphics g) {
		img.paint(g, this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dencker is better than EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.add(new DenckerInvader());
		frame.getContentPane().setBackground(Color.white);
	}

	@Override
	public void run() {
		
		while(true) {
			img.update();
			repaint();
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}