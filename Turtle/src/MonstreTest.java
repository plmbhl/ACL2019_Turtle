
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class MonstreTest {

	
	@Test
	void Droite() {
		Monstre m = new Monstre();
		m.x=0;
		m.y=0;
		m.dx=1;
		m.moveRight();
		assertEquals(m.x,1);
	}
	
	@Test
	void Gauche() {
		Monstre m = new Monstre();
		m.x=0;
		m.y=0;
		m.dx=-1;
		m.moveLeft();
		m.dx=-1;
		m.moveLeft();
		assertEquals(m.x,-2);
	}
	
	@Test
	void Haut() {
		Monstre m = new Monstre();
		m.x=0;
		m.y=0;
		m.dy=-1;
		m.moveUp();
		assertEquals(m.y,-1);
	}
	
	@Test
	void Bas() {
		Monstre m = new Monstre();
		m.x=0;
		m.y=0;
		m.dy=1;
		m.moveDown();
		assertEquals(m.y,1);
	}
	
	@Test
	void Obstacle() {
		Monstre m = new Monstre();
		m.x=1;
		m.y=5;
		int[] lab = ReadFile.read("testmapa1case");
		m.move();
		assertEquals(m.x,1);
		assertEquals(m.y,5);
	}
	
	void sortirObstacle() {
		Monstre m = new Monstre();
		m.x=26;
		m.y=0;
		Labyrinthe.lab = ReadFile.read("testmapfranchirobstacle");
		m.move();
		Boolean b = (m.x==0 || m.x==50);
		assertEquals(b,true);
	}

}
