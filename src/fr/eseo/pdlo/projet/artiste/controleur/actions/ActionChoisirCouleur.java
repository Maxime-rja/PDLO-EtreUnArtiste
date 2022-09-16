package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends javax.swing.AbstractAction
{
	private static final long serialVersionUID = 1L;

	public static final String NOM_ACTION = "Choisir couleur";

	private PanneauDessin panneauDessin;

	public ActionChoisirCouleur(PanneauDessin panneauDessin)
	{
		super(NOM_ACTION);
	    this.panneauDessin = panneauDessin;
	}

	public void actionPerformed(ActionEvent event) 
	{
		Color couleur = JColorChooser.showDialog(this.panneauDessin,NOM_ACTION,this.panneauDessin.getCouleurCourante());
	    if(couleur!=null)
	    {
	       this.panneauDessin.setCouleurCourante(couleur);
	    }
	 }
}
