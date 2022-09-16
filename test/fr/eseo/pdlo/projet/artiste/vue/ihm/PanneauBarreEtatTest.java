package fr.eseo.pdlo.projet.artiste.vue.ihm;


import java.awt.BorderLayout;



public class PanneauBarreEtatTest 
{
	public PanneauBarreEtatTest()
	{
		testConstructeurParDefaut(); 
		testConstructeur(); 
	}
	
	private void testConstructeurParDefaut()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Etre un Artiste");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);	
		PanneauDessin panneauD = new PanneauDessin(500,400);
		
		PanneauBarreEtat loc = new PanneauBarreEtat(panneauD);
		maFenetre.add(loc,BorderLayout.SOUTH);
		
		maFenetre.add(panneauD);
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}
	
	private void testConstructeur()
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame();
		maFenetre.setTitle("Blues du Businessman");
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		PanneauDessin panneauD = new PanneauDessin();
		
		PanneauBarreEtat loc = new PanneauBarreEtat(panneauD);
		maFenetre.add(loc,BorderLayout.SOUTH);
		
		maFenetre.add(panneauD);
		maFenetre.pack();
		maFenetre.setVisible(true);
		maFenetre.repaint();
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new PanneauBarreEtatTest();
			}
		});
	}
}
