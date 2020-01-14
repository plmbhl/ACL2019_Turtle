import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Labyrinthe extends JPanel implements ActionListener{



	private int longueur = 25;
	private int nombre_carre = 15;
	private int taille_fenetre = nombre_carre * longueur;
	private Timer timer = new Timer(30, (ActionListener) this);
	private Color bleu = new Color(0, 0, 200);
	private Color rouge = new Color(200,0,0);
	private Color vert = new Color(0,200,0);
	private Color rose = new Color(100,0,100);
	Heros h = new Heros();
	Monstre m = new Monstre();
	Fantome f = new Fantome();
	Monstre m1 = new Monstre();
	Monstre m2 = new Monstre();
	Monstre m3 = new Monstre();
	Monstre m4 = new Monstre();
	Monstre m5 = new Monstre();
	Monstre m6 = new Monstre();
	Monstre m7 = new Monstre();
	Passage p = new Passage();
	ArrayList<Monstre> Monstres = new ArrayList();
	Boolean chargementVie = false;
	static Boolean tir = false;
	Boolean piege = true;
	static Boolean choixFait = false;

	// gauche = 1
	// haut = 2
	// droite = 4
	// bas = 8
	// rien = 0

	private void remplirListeMonstres(int level) {
		int nombre = 0;
		switch (level) {
		case 0:
			Monstres = new ArrayList();
			Monstres.add(m1);
		case 1:
			nombre = 1;
			Monstres = new ArrayList();
			Monstres.add(m1);
			Monstres.add(m2);
			Monstres.add(m3);
			break;
		case 2:
			Monstres = new ArrayList();
			Monstres.add(m1);
			Monstres.add(m2);
			Monstres.add(m3);
			Monstres.add(m4);
			Monstres.add(m5);
			break;

		case 3:
			Monstres = new ArrayList();
			Monstres.add(m1);
			Monstres.add(m2);
			Monstres.add(m3);
			Monstres.add(m4);
			Monstres.add(m5);
			Monstres.add(m6);
			Monstres.add(m7);
			break;
		}
	}

	static int[] lab;

	private void genererLabyrinthe(Graphics2D g2d,int map) {
		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		try {
			File turtle = new File(adressedufichier + "turtle.png");
			g2d.drawImage(ImageIO.read(turtle), 0, 15*25, 389, 26, null);
		} catch (IOException ie) {
			System.out.println("Erreur :"+ie.getMessage());
		}
		if (map==0) {
			lab=ReadFile.read("labyrinthe_vide");
		}
		if (map==1) {
			lab=ReadFile.read("lab_intial");
		}
		if (map==2) {
			lab=ReadFile.read("hardcorelele");
		}
		if (map==3) {
			lab=ReadFile.read("hardcorelele2");
		}
		g2d.setColor(vert);
		int i = 0;
		for (int y = 0; y < taille_fenetre; y += longueur) {
			for (int x = 0; x < taille_fenetre; x += longueur) {
				if ((lab[i] & 1) != 0) { 
					g2d.drawLine(x,y,x,y+longueur-1);
				}
				if ((lab[i] & 2) != 0) { 
					g2d.drawLine(x,y,x+longueur-1,y);
				}
				if ((lab[i] & 4) != 0) { 
					g2d.drawLine(x+longueur-1,y,x+longueur-1,y+longueur-1);
				}
				if ((lab[i] & 8) != 0) { 
					g2d.drawLine(x, y+longueur-1,x+longueur-1,y+longueur-1);
				}
				i++;
			}
		}
		if (choixFait==false) {
			g2d.setColor(Color.YELLOW);
			g2d.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
			try {
				File intro = new File(adressedufichier + "pageintro.jpg");
				g2d.drawImage(ImageIO.read(intro), 0, 0, 389, 450, null);
			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
			for (Monstre m : Monstres) {
				m.reset();
			}
			f.reset();
		}
	}

	public void ChoixLevel(Graphics2D g2d) {
		//		if (choixFait==false) {
		//			g2d.setColor(Color.YELLOW);
		//			g2d.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		//			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		//			try {
		//				File intro = new File(adressedufichier + "pageintro.jpg");
		//				g2d.drawImage(ImageIO.read(intro), 0, 0, 389, 450, null);
		//			} catch (IOException ie) {
		//				System.out.println("Erreur :"+ie.getMessage());
		//			}
		//			for (Monstre m : Monstres) {
		//				m.reset();
		//			}
		//			f.reset();
		//		}
	}

	public void afficherVie(Graphics g2d) {
		boolean b=false;
		if (choixFait==true){
			for (int i=0; i<h.vitalite; i++) {
				String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
				try {
					File soin = new File(adressedufichier + "soin.png");
					g2d.drawImage(ImageIO.read(soin), 20*i, 15*25, 25, 25, null);
				} catch (IOException ie) {
					System.out.println("Erreur :"+ie.getMessage());
				}
			}
			for (int i=0; i<Monstres.size(); i++) {
				if ((Monstres.get(i).x == h.x & Monstres.get(i).y == h.y) || (f.x == h.x && f.y == h.y)) {
					// (Principale.map==1 && h.x==0 && h.y==14*25) || (Principale.map==3 && h.x==0 && h.y==14*25) || (Principale.map==2 && h.x==14*25 && h.y==0)
					b = true;
				}
			}
		}
		if (b==true) {
			h.vitalite--;
			//System.out.println("kakakakkaka");
		}
		//		if (h.vitalite==0) {
		//			GameOver(g2d);
		////			setVisible(false);
		////			System.out.println("GAME OVER");
		//		}
		if (h.x == 7*25 && h.y == 7*25 && chargementVie==false) {
			if (h.vitalite==2) {
				h.vitalite=3;
				chargementVie=true;
			}
			if (h.vitalite==1 && chargementVie==false) {
				h.vitalite=2;
				chargementVie=true;
			}
			//			for (int j=0; h.vitalite<3; j++) {
			//				h.vitalite++;
			//			}
		}

	}

	public void chargerImage(Graphics2D g2d,int dxx, int dyy) {

		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";

		try {

			File input1 = new File(adressedufichier + "heros.gif");
			h.image_heros = ImageIO.read(input1);
			g2d.drawImage(h.image_heros, dxx, dyy, 25, 25,null);

			File input2 = new File(adressedufichier + "soin.png");
			if (chargementVie==false) {
				g2d.drawImage(ImageIO.read(input2), 7*25, 7*25, 25, 25, null);
			}
			if (piege==true) {
				File input3 = new File(adressedufichier + "piege.png");
				switch (Principale.map) {
				case 1 :
					g2d.drawImage(ImageIO.read(input3), 0, 14*25, 25, 25, null);
					break;
				case 2:
					g2d.drawImage(ImageIO.read(input3), 14*25, 0, 25, 25, null);
					break;
				case 3:
					g2d.drawImage(ImageIO.read(input3), 0, 14*25, 25, 25, null);
					break;
				}
				if (chargementVie==false) {
					g2d.drawImage(ImageIO.read(input2), 7*25, 7*25, 25, 25, null);
				}}

		} catch (IOException ie) {
			System.out.println("Erreur :"+ie.getMessage());
		}

	}


	public void chargerImageTresor(Graphics g2d) {
		if (Principale.map==3) {
			Tresor tresor = new Tresor();
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {
				File input = new File(adressedufichier + "tresor.png");
				tresor.image_tresor=ImageIO.read(input);
				g2d.drawImage(tresor.image_tresor, tresor.x, tresor.y, 25, 25, null);
			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void chargerImagePassage(Graphics g2d) {
		if (h.vitalite>0) {
			if (Principale.map==1 || Principale.map==2) {
				String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
				try {
					File input = new File(adressedufichier + "passage.png");
					p.image_passage=ImageIO.read(input);
					g2d.drawImage(p.image_passage, p.x, p.y, 25, 25, null);
				} catch (IOException ie) {
					System.out.println("Erreur :"+ie.getMessage());
				}
			}
		}
	}

	public void chargerImageMonstre(Graphics g2d, int x, int y, Monstre M) {
		if (choixFait==true) {
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {		
				File input = new File(adressedufichier + "monstre.png");
				M.image_monstre = ImageIO.read(input);
				g2d.drawImage(M.image_monstre, x, y, 25, 25, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
		//		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		//		try {		
		//			File input = new File(adressedufichier + "monstre.png");
		//			M.image_monstre = ImageIO.read(input);
		//			g2d.drawImage(M.image_monstre, x, y, 25, 25, null);
		//
		//		} catch (IOException ie) {
		//			System.out.println("Erreur :"+ie.getMessage());
		//		}
	}

	public void chargerImageFantome(Graphics g2d, int x, int y) {
		if (choixFait==true) {
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {		
				File input = new File(adressedufichier + "ghost.png");
				f.image_fantome = ImageIO.read(input);
				g2d.drawImage(f.image_fantome, x, y, 25, 25, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void GameOver(Graphics g2d) {
		if (h.vitalite<=0) {
			for (int i=0; i<Monstres.size(); i++) {
				Monstres.get(i).enVie=false;
			}
			f.enVie=false;

			//non utilisé pour l'instant on se contente de fermer la fenêtre
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {

				File input1 = new File(adressedufichier + "gameover.png");
				g2d.drawImage(ImageIO.read(input1), 0, 0, 400, 450, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
			timer.stop();

		}
	}

	public void PartieGagnee(Graphics g2d) {
		if (h.x == 350 && h.y == 350 && Principale.map==3) {
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {

				File input2 = new File(adressedufichier + "partiegagnee.jpg");
				g2d.drawImage(ImageIO.read(input2), 0, 0, 389, 450, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void deplacementMonstre(Graphics g2d, Monstre M) {
		M.move();
		M.setX(M.getX()+(M.dx*3));
		M.setY(M.getY()+(M.dy*3));
		chargerImageMonstre(g2d, M.getX(), M.getY(),M);
	}

	public void deplacementMonstres(Graphics g2d) {
		remplirListeMonstres(Principale.level); // A CHANGER LE JOUEUR DOIT POUVOIR CHOISIR LE NIVEAU QUIL VEUT
		for (int i=0; i<Monstres.size(); i++) {
			if (Monstres.get(i).enVie == true) {
				deplacementMonstre(g2d,Monstres.get(i));
			}
		}
	}

	public void deplacementFantome(Graphics g2d) {
		f.move();
		f.setX(f.getX()+(f.dx*3));
		f.setY(f.getY()+(f.dy*3));
		if (f.enVie == true) {
			chargerImageFantome(g2d, f.getX(), f.getY());
		}
	}

	public void passageMapSuivante(Graphics g2d) {
		if (Principale.map!=3) {
			if (h.x == p.x && h.y == p.y ) {
				h.reset();
				for (Monstre m : Monstres) {
					m.reset();
				}
				f.reset();
				Principale.map++;
				piege=true;
			}
		}
	}

	public void tirMonstre(Monstre m) {
		m.enVie=false;
	}

	public void tirFantome(Fantome f) {
		f.enVie=false;
		System.out.println("coucou");
	}

	public void perteViePiege(Graphics g2d) {
		if (piege==true) {
			if ((Principale.map==1 && h.x==0 && h.y==14*25) || (Principale.map==3 && h.x==0 && h.y==14*25) || (Principale.map==2 && h.x==14*25 && h.y==0)) {
				h.vitalite--;
				piege=false;
			}
		}
	}

	public void tueMonstre(Graphics g2d) {
		if (tir==true) {
			for (int i=0; i<Monstres.size(); i++) {
				if ((Math.abs(h.y-Monstres.get(i).y))<30 && (Math.abs(h.x-Monstres.get(i).x))<30) {
					tirMonstre(Monstres.get(i));
					tir=false;
				}
				else {
					tir=false;
				}
			}
		}
	}

	public void tueFantome(Graphics g2d) {
		if (tir==true) {
			System.out.println("coucou");
			if ((Math.abs(h.y-f.y))<100 && (Math.abs(h.x-f.x))<100) {
				tirFantome(f);
				tir=false;
			}
			else {
				tir=false;
			}
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		trace(g);
	}

	public void trace(Graphics g) {
		setBackground(new Color(0,0,0));
		//timer = new Timer(30, (ActionListener) this);
		timer.start();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0,0,17*25,17*25);
		//GameOver(g2d);
		ChoixLevel(g2d);
		chargerImage(g2d,h.getX(),h.getY());
		genererLabyrinthe(g2d,Principale.map);
		GameOver(g2d);
		deplacementMonstres(g2d);
		deplacementFantome(g2d);
		afficherVie(g2d);
		tueMonstre(g2d);
		chargerImageTresor(g2d);
		perteViePiege(g2d);
		passageMapSuivante(g2d);
		chargerImagePassage(g2d);
		tueFantome(g2d);
		PartieGagnee(g2d);

		repaint();
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		h.move2();
		repaint();
	}


}
