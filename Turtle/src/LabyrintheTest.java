import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;

import org.junit.jupiter.api.Test;

class LabyrintheTest {

	@Test
	void passageMapTest() {
		Graphics g2d = null;
		Principale principale = new Principale();
		principale.map=1;
		Passage p = new Passage();
		Labyrinthe l = new Labyrinthe();
		l.h.x=p.x;
		l.h.y=p.y;
		l.passageMapSuivante(g2d);
		System.out.println(principale.map);
		assertEquals(principale.map,2);
	}
	
	@Test
	void passageMapTest2() {
		Graphics g2d = null;
		Principale principale = new Principale();
		principale.map=2;
		Passage p = new Passage();
		Labyrinthe l = new Labyrinthe();
		l.h.x=p.x;
		l.h.y=p.y;
		l.passageMapSuivante(g2d);
		System.out.println(principale.map);
		assertEquals(principale.map,3);
	}
	
	@Test
	void fin() {
		Graphics g2d = null;
		Principale principale = new Principale();
		principale.map=3;
		Passage p = new Passage();
		Labyrinthe l = new Labyrinthe();
		l.h.x=p.x;
		l.h.y=p.y;
		l.passageMapSuivante(g2d);
		System.out.println(principale.map);
		assertEquals(principale.map,3);
	}
	
	@Test
	void vitalite() {
		Labyrinthe l = new Labyrinthe();
		l.h.vitalite=3;
		l.m1.x=l.h.x;
		l.m1.y=l.h.y;
		Graphics g2d = null;
		l.afficherVie(g2d);
		assertEquals(l.h.vitalite,2);
	}

}
