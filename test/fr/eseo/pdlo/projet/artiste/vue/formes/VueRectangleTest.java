package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest 
{
	VueRectangle vueRectangle = new VueRectangle(new Rectangle(new Coordonnees(75,75), 75, 50));
	VueRectangle vueRectangle1 = new VueRectangle(new Rectangle(new Coordonnees(600,300), 100, 150));
	
	
	private void testConstructeurRectangle()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un artiste - Rectangle");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		PanneauDessin panneau = new PanneauDessin(500, 400);
		maFenetre.add(panneau);
		maFenetre.pack();

		panneau.ajouterVueForme(vueRectangle);
		panneau.ajouterVueForme(vueRectangle1
				);
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}
	
	public VueRectangleTest()
	{
		testConstructeurRectangle();
	}
	
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new VueRectangleTest();
			}
		});
	}
}


