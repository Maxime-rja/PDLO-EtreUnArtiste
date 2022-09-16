package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;


public class Rectangle extends Forme implements Remplissable {

	   // class constants
	   public static final double EPSILON = 0.2;

	   public Remplissage rempli; 
	   
	   // constructor
	   public Rectangle()
	   {
	      super();
	      this.rempli = Remplissage.AUCUNE;
	   }
	   
	   public Rectangle(double largeur, double hauteur)
	   {
		   super(largeur, hauteur);
			estNegatif();
			this.rempli = Remplissage.AUCUNE; 	
	   }
	   
	   
	   public Rectangle(Coordonnees coordonnees)
	   {
		   super(coordonnees);
		   this.rempli = Remplissage.AUCUNE;
	   }
	   
	   
	   public Rectangle(Coordonnees coordonnees, double largeur, double hauteur)
	   {
		   super(coordonnees, largeur, hauteur); 
		   estNegatif();
		   this.rempli = Remplissage.AUCUNE;
	   }


	   public void setLargeur(double largeur)
	   {
	      super.setLargeur(largeur);
	      estNegatif(); 
	   }
	   
	   
	   public void setHauteur(double hauteur)
	   {
	      super.setHauteur(hauteur);
	      estNegatif(); 
	   }
	   
	   
	   
	   private String getNatColor(Locale locale)
		{  
			String couleur;
			if(locale.getLanguage().equals("fr"))
			{
				couleur = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		    } 
			else if(locale.getLanguage().equals("en"))
			{
				couleur = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		    } 
			else 
			{
				couleur = "Mauvaise langue";
			}
			return couleur;
		 }
	   
	   
	   
	   public String toString()
	   {
			Locale locale = Locale.getDefault();
			DecimalFormat decimalFormat = new DecimalFormat("0.0#");
			Coordonnees coord = super.getPosition();
			return "[Rectangle " + this.rempli.getMode() + "] : pos (" + decimalFormat.format(coord.getAbscisse())
			+ " , " +decimalFormat.format(coord.getOrdonnee())
			+") dim "+decimalFormat.format(super.getLargeur())+" x "
			+decimalFormat.format(super.getHauteur())
			+" périmètre : " + decimalFormat.format(this.perimetre())
			+" aire : " + decimalFormat.format(this.aire())
			+" couleur = "+ this.getNatColor(locale); 
	   } 
	   

	   public double aire()
	   {
		   return (super.getHauteur()*super.getLargeur());
	   }
	   
	   
	   public double perimetre()
	   {
		   return (2*(super.getLargeur()))+(2*super.getHauteur());
	   }

		
	   public boolean contient(Coordonnees coordonnees)
	   {
	      double x = coordonnees.getAbscisse();
	      double y = coordonnees.getOrdonnee();
	      boolean containX = x > this.getCadreMinX() && x < this.getCadreMinX()+this.getLargeur();
	      boolean containY = y > this.getCadreMinY() && y < this.getCadreMinY()+this.getHauteur();
	      return (containX && containY);
	  }
	   
	   
	  public void estNegatif()
	  {
		  if(super.getLargeur() < 0)
		  {
				throw new IllegalArgumentException("Largeur negative");
		  }
		  if(super.getHauteur() < 0)
		  {
			  throw new IllegalArgumentException("Hauteur negative");
		  }
	  }

	  public Remplissage getRemplissage()
	  {
		  return this.rempli; 
	  }
	  
		
	  public void setRemplissage(Remplissage modeRemplissage)
	  {
		  this.rempli = modeRemplissage; 
	  }

}

