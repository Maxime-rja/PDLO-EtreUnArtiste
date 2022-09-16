package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest 
{

	public void testConstucteurOutil()
	{
		PanneauDessin panneau = new PanneauDessin(500, 400);
		OutilLigne outilLigne = new OutilLigne();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setTitle("Etre un Artiste - OutilLigne");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panneau);
		panneau.associerOutil(outilLigne);
		frame.add(panneau);
		frame.setVisible(true);
		frame.pack();
		frame.repaint();
	}
	
	public OutilLigneTest()
	{
		testConstucteurOutil();
	}

	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new OutilLigneTest();
			}
		});
	}
}
