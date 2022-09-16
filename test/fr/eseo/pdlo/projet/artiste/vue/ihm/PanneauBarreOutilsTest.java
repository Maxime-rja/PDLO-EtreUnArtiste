package fr.eseo.pdlo.projet.artiste.vue.ihm;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;

public class PanneauBarreOutilsTest 
{

	public PanneauBarreOutilsTest() 
	{
		testConstructeurSelection();
	}

	public void testConstructeurSelection()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un Artiste - Selection");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		OutilSelectionner outilSelectionner = new OutilSelectionner();
		PanneauDessin panneauD = new PanneauDessin(500, 400);
		panneauD.associerOutil(outilSelectionner);
		maFenetre.add(panneauD);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauD);
		maFenetre.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		maFenetre.setLocationRelativeTo(null); 
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}

	public static void main(String [] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new PanneauBarreOutilsTest();
			}
		});
	}
}
