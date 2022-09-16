package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme  implements Remplissable
{
	public Remplissage rempli; 
	
	public static final double EPSILON = 0.2;
	
	
	
	public Ellipse()
	{
		super();
		this.rempli = Remplissage.AUCUNE;
	}
	
	public Ellipse (double largeur, double hauteur)
	{
		super(largeur, hauteur);
		estNegatif();
		this.rempli = Remplissage.AUCUNE; 
	}
	
	public Ellipse (Coordonnees position)
	{
		super(position);
		this.rempli = Remplissage.AUCUNE;
	}
	
	public Ellipse(Coordonnees position, double largeur, double hauteur)
	{
		super(position, largeur, hauteur); 
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
	
	double petitRayon = 0; 
	double grandRayon = 0; 
	
	public String toString() 
	{
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		Coordonnees coord = super.getPosition();
		if (getLargeur() > super.getHauteur())
		{
			petitRayon = getHauteur(); 
			grandRayon = getLargeur(); 
		}
		else
		{
			petitRayon = getLargeur(); 
			grandRayon = getHauteur();
		}
		return "[Ellipse" + " " + this.rempli.getMode() + "] : pos (" + decimalFormat.format(coord.getAbscisse())+" , "
			+decimalFormat.format(coord.getOrdonnee())
			+") petit rayon "+decimalFormat.format(petitRayon/2)+" grand rayon "+decimalFormat.format(grandRayon/2)
			+" périmètre : "+decimalFormat.format(this.perimetre())
			+" aire : "+decimalFormat.format(this.aire())
			+" couleur = "+this.getNatColor(locale);
	}

	public Remplissage getRemplissage()
	{
		return this.rempli; 
	}
	
	public void setRemplissage(Remplissage modeRemplissage)
	{
		this.rempli = modeRemplissage; 
	}
	
	public double aire() 
	{
		return Math.PI*(super.getLargeur()/2)*(super.getHauteur()/2);
	}

	
	
	public double perimetre() 
	{
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		double c = Math.pow((a-b)/(a+b),2);
		return Math.PI*(a+b)*(1+((3*c)/(10+Math.sqrt(4-3*c))));
	}
	
	
	public boolean contient(Coordonnees coordonnees)
	{
		return ((Math.pow(coordonnees.getAbscisse() - (this.getPosition().getAbscisse() 
				+ this.getLargeur() / 2), 2) / (Math.pow(this.getLargeur() / 2, 2)) 
				+ Math.pow(coordonnees.getOrdonnee() - (this.getPosition().getOrdonnee() 
				+ this.getHauteur() / 2), 2) / (Math.pow(this.getHauteur() / 2, 2))) <= 1);
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
}
