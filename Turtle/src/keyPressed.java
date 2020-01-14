import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyPressed implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		int codeDeLaTouche = arg0.getKeyCode();
		switch (codeDeLaTouche) 
		{
		case KeyEvent.VK_UP: 
			Heros.dy=1;
			break;
		case KeyEvent.VK_LEFT: 
			Heros.dx=-1;
			break;
		case KeyEvent.VK_RIGHT: 
			Heros.dx=1;
			break;
		case KeyEvent.VK_DOWN: 
			Heros.dy=-1;
			break;
		case KeyEvent.VK_1:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=1;
			}
			break;

		case KeyEvent.VK_2:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=2;
				break;
			}
		case KeyEvent.VK_3:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=3;
				break;
			}
		case KeyEvent.VK_NUMPAD1:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=1;
			}
			break;

		case KeyEvent.VK_NUMPAD2:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=2;
				break;
			}
		case KeyEvent.VK_NUMPAD3:
			if (Labyrinthe.choixFait==false) {
				Labyrinthe.choixFait=true;
				Principale.level=3;
				break;
			}
		case KeyEvent.VK_SPACE:
			Labyrinthe.tir = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
