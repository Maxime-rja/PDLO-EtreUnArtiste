package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest 
{
	public OutilEllipseTest() 
	{
		testConstructeurOutil();
	}

	public void testConstructeurOutil()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Construction Ellipse");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneauD = new PanneauDessin(500, 400);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauD);
		OutilEllipse outilEllipse = new OutilEllipse();
		panneauD.associerOutil(outilEllipse);
		maFenetre.add(panneauD, java.awt.BorderLayout.SOUTH);
		maFenetre.add(panneauBarreOutils);
		maFenetre.setVisible(true);
		maFenetre.pack();
		maFenetre.repaint();
	}

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new OutilEllipseTest();
			}
		});
	}
}
