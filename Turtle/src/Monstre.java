import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Monstre extends JPanel {
	public int x=24*14;
	public int y;
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
	
	public void move() {
		if (x>=0 & y==0) {
			moveLeft(1);
		}
		if (x<1) {
			moveDown(1);
		}
		if (y>=14*25 & x<=14*25) {
			moveRight(1);
		}
		if (x==14*25 & y>0) {
			moveUp(1);
		}
	}


	private void moveRight(int d_x) {
		// TODO Auto-generated method stub
		setX(x+d_x);
	}


	private void moveLeft(int d_x) {
		// TODO Auto-generated method stub
		setX(x-d_x);
	}


	private void moveDown(int d_y) {
		// TODO Auto-generated method stub
		setY(y+d_y);
	}


	private void moveUp(int d_y) {
		// TODO Auto-generated method stub
		setY(y-d_y);
	}
}