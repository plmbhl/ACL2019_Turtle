import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Monstre extends JPanel {
//	public int x=25*14;
//	public int y=0;
	public int x=25*10;
	public int y=25*5;
	public Image image_monstre;
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
	

	void moveRight() {
		// TODO Auto-generated method stub
		setX(x+1);
		dx=1;
		dy=0;
	}


	 void moveLeft() {
		// TODO Auto-generated method stub
		setX(x-1);
		dx=-1;
		dy=0;
	}


	void moveDown() {
		// TODO Auto-generated method stub
		setY(y+1);
		dx=0;
		dy=1;
	}


	void moveUp() {
		// TODO Auto-generated method stub
		setY(y-1);
		dx=0;
		dy=-1;
	}
}