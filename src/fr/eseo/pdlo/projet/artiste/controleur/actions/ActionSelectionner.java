package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends javax.swing.AbstractAction {

	   private static final long serialVersionUID = 1L;

	   // class constants
	   public static final String NOM_ACTION = "Sélectionner";
	   
	   // attributes
	   private PanneauDessin panneauDessin;

	   // constructor
	   public ActionSelectionner(PanneauDessin panneauDessin) {
	      super(NOM_ACTION);
	      this.panneauDessin=panneauDessin;
	   }

	   // methodes
	   public void actionPerformed(ActionEvent event)
	   {
	      if(event.getActionCommand()==NOM_ACTION)
	      {
	         this.panneauDessin.associerOutil(new OutilSelectionner());
	      }
	   }
}
