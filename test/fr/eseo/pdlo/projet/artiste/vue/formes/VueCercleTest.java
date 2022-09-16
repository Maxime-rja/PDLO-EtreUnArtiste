package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest
{
	VueCercle vueCercle = new VueCercle(new Cercle(new Coordonnees(200, 100),100));
	
	 
	private void testConstructeurCercle()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un artiste - Cercle");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(500, 400);
		
		Cercle cercle1 = new Cercle(); 
		cercle1.setCouleur(Color.RED);
		VueCercle vueCercle1 = new VueCercle(cercle1); 
		
		maFenetre.add(panneau);
		maFenetre.pack();
		panneau.ajouterVueForme(vueCercle1);
		maFenetre.setVisible(true);
		maFenetre.repaint();
		
	}
	
	public VueCercleTest()
	{
		testConstructeurCercle(); 
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new VueCercleTest();
			}
		});
	}
}

