package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;


public class OutilRectangle extends OutilForme {
	  
	protected VueForme creerVueForme() 
	{
		double abs1 = this.getDebut().getAbscisse();
		double abs2 = this.getFin().getAbscisse();
		double ord1 = this.getDebut().getOrdonnee();
		double ord2 = this.getFin().getOrdonnee();
		Rectangle rec = new Rectangle();
		rec.setLargeur(Math.abs(abs2 - abs1));
		rec.setHauteur(Math.abs(ord2 - ord1));
		rec.setCouleur(this.getPanneauDessin().getCouleurCourante());
		rec.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		if (abs1 > abs2) 
		{
			if (ord1 < ord2) 
			{
				abs1 = abs2;
			}
			else 
			{
				abs1 = abs2;
				ord1 = ord2;
			}
		} 
		else if (ord1 > ord2)
		{
			ord1 = ord2;
		}
		rec.setPosition(new Coordonnees(abs1, ord1));
		return new VueRectangle(rec);
	}
}
