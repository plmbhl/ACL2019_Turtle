
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Labyrinthe extends JFrame {
	// 2 : héros
	// 0 : passage
	// 1 : mur
	
	// Generation aléatoire à développer pour les prochains sprints
    private int [][] lab = 
        { {2,0,0,1,1,1,1,1,1,1,1,1,1},
          {0,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,1,1,1,1,1,1,1,1,0,0,0,0}
        };
    
    
    public Labyrinthe() {
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
    
    public void paint(Graphics g) {
    	g.translate(50, 50);
        for (int ligne = 0; ligne < lab.length; ligne++) {
            for (int col = 0; col < lab[0].length; col++) {
                Color color;
                switch (lab[ligne][col]) {
                    case 1 : color = Color.BLACK; break;
                    case 2 : color = Color.RED; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(20 *col, 20 *ligne,20,20);
                g.setColor(Color.BLACK);
                g.drawRect(20*col,20*ligne,20,20);
            }
        }
    }
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Labyrinthe l1 = new Labyrinthe();
                l1.setVisible(true);
            }
        });
    }
    
}