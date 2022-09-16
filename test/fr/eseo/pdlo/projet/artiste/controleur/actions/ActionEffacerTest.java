package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest 
{
	public ActionEffacerTest()
	{
		testActionEffacer();
	}

	private void testActionEffacer()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Test Pour Tout Effacer");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		OutilLigne outilLigne = new OutilLigne();
		PanneauDessin panneauD = new PanneauDessin(500, 400);
		panneauD.associerOutil(outilLigne);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauD);
		maFenetre.add(panneauD, java.awt.BorderLayout.SOUTH);
		maFenetre.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
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
				new ActionEffacerTest();
			}
		});
	}
}
