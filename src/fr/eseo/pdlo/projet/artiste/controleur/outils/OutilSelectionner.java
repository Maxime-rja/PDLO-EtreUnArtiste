package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilSelectionner extends Outil
{
	// attributes
	   private Forme formeSelectionee;

	   // constructor
	   public OutilSelectionner(){}

	   // methodes
	   public void mouseClicked(MouseEvent event)
	   {
	      for(int i=1; i<this.getPanneauDessin().getVueFormes().size(); i++)
	      {
	         if(this.getPanneauDessin().getVueFormes().get(i).getForme().contient(new Coordonnees(event.getX(), event.getY()))) 
	         {
	            this.formeSelectionee = this.getPanneauDessin().getVueFormes().get(i).getForme();
	         }
	      }
	      
	      JOptionPane.showConfirmDialog(this.getPanneauDessin(), this.formeSelectionee, ActionSelectionner.NOM_ACTION, 
	      JOptionPane.INFORMATION_MESSAGE);
	   }
}
