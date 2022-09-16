package fr.eseo.pdlo.projet.artiste.vue.formes;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;


public class VueLigneTest 
{
	VueLigne vueLigne = new VueLigne(new Ligne(new Coordonnees(600, 300),200,250));
	
	
	private void testConstructeurLigne()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un Artiste - ligne");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneauD = new PanneauDessin(500, 400);
		maFenetre.add(panneauD);
		maFenetre.pack(); 
		panneauD.ajouterVueForme(vueLigne);
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}
	
	public VueLigneTest()
	{
		testConstructeurLigne();
	}


	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new VueLigneTest();
			}
		});
	}
}
