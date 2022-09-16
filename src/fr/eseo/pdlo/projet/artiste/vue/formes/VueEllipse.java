package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
//External imports
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
//internal imports
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;


public class VueEllipse extends VueForme
{ 
	
	// constructor
	public VueEllipse(Ellipse ellipse)
	{
		super(ellipse); 
	}

		   
	// methodes
	public void affiche(Graphics2D g2d) 
	{
		Color color = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		int abs = (int)((Ellipse) this.getForme()).getPosition().getAbscisse();
		int ord = (int)((Ellipse) this.getForme()).getPosition().getOrdonnee();
		int largeur = (int)((Ellipse) this.getForme()).getLargeur();
		int hauteur = (int)((Ellipse) this.getForme()).getHauteur();
		if (((Ellipse)this.forme).getRemplissage() == Remplissage.UNIFORME)
		{
			g2d.fillOval(abs, ord, largeur, hauteur);
		}
		g2d.drawOval(abs, ord, largeur, hauteur);
		g2d.setColor(color);
	}
}

