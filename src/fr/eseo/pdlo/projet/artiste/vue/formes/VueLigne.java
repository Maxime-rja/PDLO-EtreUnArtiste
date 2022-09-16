package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme
{
	public VueLigne(Ligne ligne)
	{
		super(ligne); 
	}
	
	public void affiche(Graphics2D g2d)
	{
		Color color = g2d.getColor();
	    g2d.setColor(this.getForme().getCouleur());
		int abs1 = (int)((Ligne) this.getForme()).getC1().getAbscisse();
        int abs2 = (int)((Ligne) this.getForme()).getC2().getAbscisse();
        int ord1 = (int)((Ligne) this.getForme()).getC1().getOrdonnee();
        int ord2 = (int)((Ligne) this.getForme()).getC2().getOrdonnee();
	    g2d.drawLine(abs1, ord1, abs2, ord2);
	    g2d.setColor(color);
	}
}

