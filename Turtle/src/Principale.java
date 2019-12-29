import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Principale extends JFrame {
	
	static int level=1;
	static boolean changement=false;
	static boolean on=false;
	private Timer timer;

    public Principale() {
        
        initUI();
    }
    
    private void initUI() {
        add(new Labyrinthe());
        addKeyListener(new keyPressed());
        setTitle("PacTurtle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
//    	Scanner sc = new Scanner(System.in);
//        System.out.println("Saisissez le niveau souhaité de 0 à 3");
//        level = sc.nextInt();
        EventQueue.invokeLater(() -> {
            Principale Turtle = new Principale();
            Turtle.setVisible(true);
        });
    }



}