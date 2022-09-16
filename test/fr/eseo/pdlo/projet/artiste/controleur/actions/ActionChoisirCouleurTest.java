package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleurTest 
{
	public ActionChoisirCouleurTest()
	{
		testChoisirCouleur();
	}

	public void testChoisirCouleur()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un Artiste - choix couleur");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneauD = new PanneauDessin(500, 400);
		OutilLigne outilL = new OutilLigne();
		panneauD.associerOutil(outilL);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauD);
		maFenetre.add(panneauD, java.awt.BorderLayout.CENTER);
		maFenetre.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		maFenetre.setVisible(true);
		maFenetre.pack();
		maFenetre.repaint();
	}

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new ActionChoisirCouleurTest();
			}
		});
	}

}

