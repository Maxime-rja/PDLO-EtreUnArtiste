package fr.eseo.pdlo.projet.artiste.vue.ihm;


public class PanneauDessinTest 
{
	public PanneauDessinTest()
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
				new PanneauDessinTest();
			}
		});
	}	
}
