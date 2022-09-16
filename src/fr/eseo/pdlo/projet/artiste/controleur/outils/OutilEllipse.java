package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme
{
	 protected VueForme creerVueForme()
	 {
	      double abs1 = this.getDebut().getAbscisse();
	      double abs2 = this.getFin().getAbscisse();
	      double ord1 = this.getDebut().getOrdonnee();
	      double ord2 = this.getFin().getOrdonnee();
	      Ellipse ell = new Ellipse();
	      ell.setLargeur(Math.abs(abs2 - abs1));
	      ell.setHauteur(Math.abs(ord2 - ord1));
	      ell.setCouleur(this.getPanneauDessin().getCouleurCourante());
	      ell.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
	      if(abs1>abs2)
	      {
	         if(ord1 < ord2)
	         {
	        	 abs1 = abs2;
	         } 
	         else 
	         {
	        	 abs1 = abs2;
	        	 ord1 = ord2;
	         }
	      } 
	      else if(ord1 > ord2)
	      {
	    	  ord1 = ord2;
	      }
	      ell.setPosition(new Coordonnees(abs1,ord1));
	      return new VueEllipse(ell);
	   }
}
