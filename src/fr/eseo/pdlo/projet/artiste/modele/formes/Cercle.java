package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse
{
	//Constructors
	public Cercle()
	{
		this(LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille)
	{
		super (taille, taille); 
	}
	
	public Cercle(Coordonnees position)
	{
		this(position, LARGEUR_PAR_DEFAUT); 
	}
	
	public Cercle(Coordonnees position, double taille)
	{
		super(position, taille, taille); 
	}
	
	public void setHauteur(double hauteur)
	{
		super.setHauteur(hauteur);
		super.setLargeur(hauteur); 
	}
	
	public void setLargeur(double largeur) 
	{
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	public double perimetre()
	{
		return 2*Math.PI*super.getLargeur()/2;
	}
	
	public double aire() 
	{
		return Math.PI*Math.pow(super.getLargeur()/2,2); 
	}
	
	private String getNatColor(Locale locale)
	{  
		String color;
		if(locale.getLanguage().equals("fr"))
		{
			color = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
	    } 
		else if(locale.getLanguage().equals("en"))
		{
			color = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
	    } 
		else 
		{
			color = "Mauvaise langue";
		}
		return color;
	 }
	
	
	public String toString()
	{
		Locale locale = Locale.getDefault();
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		Coordonnees coord = super.getPosition();
		
		return "[Cercle " + this.rempli.getMode() + "] : pos (" + decimalFormat.format(coord.getAbscisse()) + " , "
         + decimalFormat.format(coord.getOrdonnee())
         + ") rayon "+decimalFormat.format(super.getLargeur()/2)
         + " périmètre : " + decimalFormat.format(this.perimetre())
         + " aire : " + decimalFormat.format(this.aire())
         + " couleur = "+ this.getNatColor(locale);
	}
	
	
}
