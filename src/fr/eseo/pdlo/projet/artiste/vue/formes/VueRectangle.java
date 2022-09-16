package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme {
 
	
	public VueRectangle(Rectangle rectangle)
	{
		super(rectangle);
	}


	public void affiche(Graphics2D g2d) 
	{
		Color color = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		int abs = (int)((Rectangle) this.getForme()).getPosition().getAbscisse();
		int ord = (int)((Rectangle) this.getForme()).getPosition().getOrdonnee();
		int larg = (int)((Rectangle) this.getForme()).getLargeur();
		int haut = (int)((Rectangle) this.getForme()).getHauteur();
   
		if(((Rectangle)this.forme).getRemplissage() == Remplissage.AUCUNE)
		{
			g2d.drawRect(abs, ord, larg, haut);
			g2d.setColor(color);
		}
		else
		{
			g2d.fillRect(abs, ord, larg, haut);
		}
	}
}
