import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Heros extends JPanel {
	public int x;
	public int y;
	public Image image_heros;
	static int dx=0;
	static int dy=0;
		
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	public void move() {
		if (dx==1) {
			setX(x+25);
		}
		if (dx==-1) {
			setX(x-25);
		}
		if (dy==-1) {
			setY(y+25);
		}
		if (dy==1) {
			setY(y-25);
		}
	}
}