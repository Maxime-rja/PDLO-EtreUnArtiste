package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends javax.swing.AbstractAction
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String NOM_ACTION = "Effacer Tout";
	
	private PanneauDessin panneauDessin;
	
	 public void actionPerformed(ActionEvent event) 
	 {
	      int answer = JOptionPane.showConfirmDialog(this.panneauDessin, NOM_ACTION + "?", NOM_ACTION, JOptionPane.YES_NO_OPTION);
	      if(answer==0)
	      {
	         this.panneauDessin.getVueFormes().clear();
	         this.panneauDessin.repaint();
	      }
	   }
	 
	 
	public ActionEffacer(PanneauDessin panneauDessin)
	{
	      super(NOM_ACTION);
	      this.panneauDessin = panneauDessin;
	}
}
