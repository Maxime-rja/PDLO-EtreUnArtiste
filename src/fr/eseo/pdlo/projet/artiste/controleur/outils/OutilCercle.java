package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme
{  
	 // methodes
	   protected VueForme creerVueForme()
	   {
	      Cercle cer = new Cercle();
	      double abs1 = this.getDebut().getAbscisse();
	      double abs2 = this.getFin().getAbscisse();
	      double ord1 = this.getDebut().getOrdonnee();
	      double ord2 = this.getFin().getOrdonnee();
	      cer.setCouleur(this.getPanneauDessin().getCouleurCourante());
	      cer.setLargeur(Math.max(Math.abs(abs2-abs1),Math.abs(ord2-ord1)));
	      cer.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
	      if(abs2<abs1)
	      {
	         if(ord1>ord2)
	         {
	        	abs1 -= cer.getLargeur();
	        	ord1 -= cer.getLargeur();
	         } 
	         else 
	         {
	        	 abs1 -= cer.getLargeur();
	         }
	      } 
	      else if(ord2<ord1)
	      {
	    	  ord1 -= cer.getLargeur();
	      }
	      cer.setPosition(new Coordonnees(abs1,ord1));
	      return new VueCercle(cer);
	   }
	   
	   
		public void mouseClicked(MouseEvent event) 
		{
			
			if (event.getClickCount() == 2) 
			{
				this.setDebut(new Coordonnees(event.getX() ,event.getY()));
				this.setFin(new Coordonnees((double) event.getX() + Forme.LARGEUR_PAR_DEFAUT,
				(double) event.getY() + Forme.LARGEUR_PAR_DEFAUT));
				this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
				this.getPanneauDessin().repaint();
			}
		}
}
