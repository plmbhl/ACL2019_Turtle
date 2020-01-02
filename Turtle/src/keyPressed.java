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
		case KeyEvent.VK_NUMPAD1:
			Principale.changement=false;
			Principale.map=1;
			break;

		case KeyEvent.VK_NUMPAD2:
			if (Principale.changement==false) {
				Principale.changement=true;
				Principale.map=2;
				break;
			}
		case KeyEvent.VK_NUMPAD3:
			if (Principale.changement==false) {
				Principale.changement=true;
				Principale.map=3;
				break;
			}
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
