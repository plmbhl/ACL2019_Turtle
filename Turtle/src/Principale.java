import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;

public class Principale extends JFrame {
	
	
	private Timer timer;

    public Principale() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Labyrinthe());
        addKeyListener(new keyPressed());
        setTitle("PacTurtle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 420);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Principale Turtle = new Principale();
            Turtle.setVisible(true);
        });
    }


}