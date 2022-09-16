package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste 
{
	private static final String NOM_PAR_DEFAUT = "Etre un Artiste";
	private static final int HAUT_PAR_DEFAUT = 640;
	private static final int LARG_PAR_DEFAUT = 480;
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				
				int cpt = args.length; 
				
				if (cpt <= 0)
				{
					new EtreUnArtiste(); 
				}
				else if(cpt >= 3)
				{
					String nom = args[0]; 
				
					int larg; 
					int haut; 
				
					try 
					{
						larg = Integer.parseInt(args[1]);
					} 
					catch (Exception ex) 
					{
						larg = LARG_PAR_DEFAUT;
					}
					try 
					{
						haut = Integer.parseInt(args[2]);
					} 
					catch (Exception ex) 
					{
						haut = HAUT_PAR_DEFAUT;
					}
					
					new EtreUnArtiste(nom, larg, haut); 
				}
			}
		});
	}
	
	
	private EtreUnArtiste()
	{
		this(NOM_PAR_DEFAUT, LARG_PAR_DEFAUT, HAUT_PAR_DEFAUT); 
	}

	private EtreUnArtiste(String nom, double haut, double larg) 
	{
		javax.swing.JFrame maFenetre = new javax.swing.JFrame(nom);
		
		maFenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		PanneauDessin panneauD = new PanneauDessin(640, 480, Color.white);
		PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils(panneauD);
		PanneauBarreEtat loc = new PanneauBarreEtat(panneauD);
		
		maFenetre.add(loc, BorderLayout.SOUTH);
		maFenetre.add(panneauD, java.awt.BorderLayout.CENTER);
		maFenetre.add(panneauBarreOutils, java.awt.BorderLayout.EAST);
		
		
		maFenetre.setVisible(true);
		maFenetre.pack();
	}
}
