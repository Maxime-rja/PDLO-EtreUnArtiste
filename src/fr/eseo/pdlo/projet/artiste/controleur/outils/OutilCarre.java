package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;


import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {

	protected VueForme creerVueForme() 
	{
		Carre car = new Carre();
		double abs1 = this.getDebut().getAbscisse();
		double abs2 = this.getFin().getAbscisse();
		double ord1 = this.getDebut().getOrdonnee();
		double ord2 = this.getFin().getOrdonnee();
		car.setLargeur(Math.max(Math.abs(abs2 - abs1), Math.abs(ord2 - ord1)));
		car.setCouleur(this.getPanneauDessin().getCouleurCourante());
		car.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		if (abs1 > abs2) 
		{
			if (ord1 > ord2) 
			{
				abs1 = abs1 - car.getLargeur();
				ord1 = ord1 - car.getLargeur();
			} 
			else 
			{
				abs1 = abs1 - car.getLargeur();
			}
		} 
		else if (ord1 > ord2) 
		{
			ord1 = ord1 - car.getLargeur();
		}
		car.setPosition(new Coordonnees(abs1, ord1));
		return new VueCarre(car);
	}

	public void mouseClicked(MouseEvent event) 
	{
		super.mouseClicked(event);
	}
}
