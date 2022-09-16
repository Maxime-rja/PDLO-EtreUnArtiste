package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle {

	public static final double EPSILON = 0.2;

	public Carre() 
	{
		super();
	}

	public Carre(double taille) 
	{
		super(taille, taille);
	}

	public Carre(Coordonnees position) 
	{
		super(position);
	}

	public Carre(Coordonnees coordonnees, double taille) 
	{
		super(coordonnees, taille, taille);
	}
	
	

	public void setHauteur(double hauteur)
	{
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}

	
	public void setLargeur(double largeur)
	{
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}
	
	
	public double aire() 
	{
		return Math.pow(super.getLargeur(), 2);
	}

	public double perimetre()
	{
		return 4 * (super.getLargeur());
	}
	

	// methodes
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
		return "[Carré " + this.rempli.getMode() + "] : pos ("
		+ decimalFormat.format(coord.getAbscisse()) + " , "
		+ decimalFormat.format(coord.getOrdonnee()) + ") dim " + decimalFormat.format(super.getLargeur())
		+ " x " + decimalFormat.format(super.getHauteur()) + " périmètre : "
		+ decimalFormat.format(this.perimetre()) + " aire : " + decimalFormat.format(this.aire())
		+ " couleur = " + this.getNatColor(locale);
	}
}
