package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest
{
	VueCarre vueCarre = new VueCarre(new Carre(new Coordonnees(700, 500),100));
	
	 
	private void testConstructeurCarre()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un artiste - Cercle");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneau = new PanneauDessin(500, 400);
		
		Carre carre1 = new Carre(); 
		carre1.setCouleur(Color.RED);
		VueCarre vueCarre1 = new VueCarre(carre1); 
		
		maFenetre.add(panneau);
		maFenetre.pack();
		panneau.ajouterVueForme(vueCarre1);
		maFenetre.setVisible(true);
		maFenetre.repaint();
		
	}
	
	public VueCarreTest()
	{
		testConstructeurCarre(); 
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new VueCarreTest();
			}
		});
	}
}

