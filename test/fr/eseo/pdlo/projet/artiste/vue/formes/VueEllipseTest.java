package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest 
{
	VueEllipse vueEllipse = new VueEllipse(new Ellipse(new Coordonnees(75,75), 75, 50));
	VueEllipse vueEllipse1 = new VueEllipse(new Ellipse(new Coordonnees(600,300), 100, 150));
	
	
	private void testConstructeurEllipse()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un artiste - Ellipse");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		PanneauDessin panneau = new PanneauDessin(500, 400);
		maFenetre.add(panneau);
		maFenetre.pack();

		panneau.ajouterVueForme(vueEllipse);
		panneau.ajouterVueForme(vueEllipse1);
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}
	
	public VueEllipseTest()
	{
		testConstructeurEllipse();
	}
	
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new VueEllipseTest();
			}
		});
	}
}


