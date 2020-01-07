import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HerosTest {

	@Test
	void testReset() {
		Heros h = new Heros();
		h.x=36;
		h.y=54;
		h.reset();
		assertEquals(h.x,0);
		assertEquals(h.y,0);
	}
	
	@Test
	void Droite() {
		Heros h = new Heros();
		h.x=0;
		h.y=0;
		h.dx=1;
		h.move();
		assertEquals(h.x,25);
	}
	
	@Test
	void Gauche() {
		Heros h = new Heros();
		h.x=0;
		h.y=0;
		h.dx=-1;
		h.move();
		h.dx=-1;
		h.move();
		assertEquals(h.x,-50);
	}
	
	@Test
	void Haut() {
		Heros h = new Heros();
		h.x=0;
		h.y=0;
		h.dy=-1;
		h.move();
		assertEquals(h.y,25);
	}
	
	@Test
	void Bas() {
		Heros h = new Heros();
		h.x=0;
		h.y=0;
		h.dy=1;
		h.move();
		assertEquals(h.y,-25);
	}
	
	@Test
	void Obstacle() {
		Heros h = new Heros();
		Labyrinthe.lab = ReadFile.read("testmapa1case");
		h.x=0;
		h.y=0;
		h.dx=1;
		h.move2();
		assertEquals(h.x,0);
	}
	
	@Test
	void sortirObstacle() {
		Heros h = new Heros();
		Labyrinthe.lab = ReadFile.read("testmapa1case");
		h.x=25;
		h.y=0;
		h.dx=-1;
		h.move2();
		assertEquals(h.x,0);
	}

}
