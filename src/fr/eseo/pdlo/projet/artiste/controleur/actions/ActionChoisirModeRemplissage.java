package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirModeRemplissage extends AbstractAction
{
	// attributes
	private PanneauDessin panneauDessin;
	private Remplissage remplissage; 

	   // constructor
	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin, Remplissage remplissage)
	{
		this.panneauDessin = panneauDessin;
		this.remplissage = remplissage;
	}
	  
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand() == Remplissage.UNIFORME.getMode())
		{
			this.panneauDessin.setModeRemplissageCourant(remplissage.UNIFORME);
	     } 
		else 
		{
	         this.panneauDessin.setModeRemplissageCourant(remplissage.AUCUNE);
	    }
	 }
}
