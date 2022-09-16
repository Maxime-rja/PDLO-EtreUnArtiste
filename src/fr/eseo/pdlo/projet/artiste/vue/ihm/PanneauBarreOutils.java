package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import javax.swing.ButtonGroup;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEnregistrer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PanneauBarreOutils extends javax.swing.JPanel
{
	private static final long serialVersionUID = 1L;
	
	//attributes
	private PanneauDessin panneauDessin;
	private Remplissage remplissage; 
	 
	
	//Constructor
	public PanneauBarreOutils(PanneauDessin panneauDessin)
	{
	      this.panneauDessin = panneauDessin;
	      super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	      initComponents();
	}
	
	
	
	// private methods
	private JToggleButton createToggleEllipse()
	{
		JToggleButton boutonEllipse = new JToggleButton
		(new ActionChoisirForme(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_ELLIPSE));
	    boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
	    return boutonEllipse;
	}
	   
	   
	private JToggleButton createToggleCercle()
	{
	    JToggleButton boutonCercle = new JToggleButton(new ActionChoisirForme(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_CERCLE));
	    boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
	    return boutonCercle;
	}
	   
	   
	private JToggleButton createToggleLigne()
	{
	    JToggleButton boutonLigne = new JToggleButton(new ActionChoisirForme(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_LIGNE));
	    boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
	    return boutonLigne;
	}
	
	private JToggleButton createToggleRectangle()
	{
		JToggleButton boutonRectangle = new JToggleButton
		(new ActionChoisirForme(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_RECTANGLE));
		boutonRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
	    return boutonRectangle;
	}
	
	private JToggleButton createToggleCarre()
	{
		JToggleButton boutonCarre = new JToggleButton
		(new ActionChoisirForme(this.panneauDessin,this,ActionChoisirForme.NOM_ACTION_CARRE));
		boutonCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
	    return boutonCarre;
	}
	
	
	
	private void initComponents()
	{
		ButtonGroup boutongrp = new ButtonGroup();
		ButtonGroup boutonRempl = new ButtonGroup(); 
			 
		JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(boutonEffacer);
		
		
		JButton boutonEnregistrer = new JButton(new ActionEnregistrer(this.panneauDessin));
		boutonEnregistrer.setName(ActionEnregistrer.NOM_ACTION);
		this.add(boutonEnregistrer);
	
		
		//Bouton Ligne
		JToggleButton boutonLigne = this.createToggleLigne();
		boutongrp.add(boutonLigne);
		this.add(boutonLigne);

		//Bouton Ellipse
		JToggleButton boutonEllipse = this.createToggleEllipse();
		boutongrp.add(boutonEllipse);
		this.add(boutonEllipse);

		//Bouton Cercle
		JToggleButton boutonCercle = this.createToggleCercle();
		boutongrp.add(boutonCercle);
		this.add(boutonCercle);
		
		//Bouton Rectangle
		JToggleButton boutonRectangle = this.createToggleRectangle();
		boutongrp.add(boutonRectangle);
		this.add(boutonRectangle);
		
		//Bouton Carre
		JToggleButton boutonCarre = this.createToggleCarre();
		boutongrp.add(boutonCarre);
		this.add(boutonCarre);
		
		//Bouton sélection
	    JToggleButton boutonSelection = new JToggleButton(new ActionSelectionner(this.panneauDessin));
	    boutonSelection.setName(ActionSelectionner.NOM_ACTION);
	    boutongrp.add(boutonSelection);
	    this.add(boutonSelection);
	    
	    //Bouton choix couleur
	    JButton colorButton = new JButton(new ActionChoisirCouleur(this.panneauDessin));
	    colorButton.setName(ActionChoisirCouleur.NOM_ACTION);
	    this.add(colorButton);
	    
	    //Bouton remplissage
	    JToggleButton boutonRemplissage = new JToggleButton(new ActionChoisirModeRemplissage(this.panneauDessin , remplissage));
	    boutonRemplissage.setName("uniforme");
	    boutonRemplissage.setText("uniforme");
	    boutonRempl.add(boutonRemplissage);
	    this.add(boutonRemplissage);
	    
	    //Bouton non remplissage
	    JToggleButton boutonPasRemplir = new JToggleButton(new ActionChoisirModeRemplissage(this.panneauDessin , remplissage));
	    boutonPasRemplir.setName("aucune");
	    boutonPasRemplir.setText("aucune");
	    boutonRempl.add(boutonPasRemplir);
	    this.add(boutonPasRemplir);
	    boutonPasRemplir.setSelected(true);   
	}
}
