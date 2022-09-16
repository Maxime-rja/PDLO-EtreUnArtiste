package fr.eseo.pdlo.projet.artiste.modele.formes;


import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme
{
	public static final double EPSILON = 0.2;
	
	public Ligne()
	{
		super(); 
	}
	
	public Ligne(Coordonnees position)
	{
		super(position); 
	}
	
	public Ligne(double largeur, double hauteur)
	{
		super(largeur, hauteur); 
	}
	

	public Ligne(Coordonnees position, double largeur, double hauteur)
	{
		super(position, largeur, hauteur);  
	}
	
	
	
	public Coordonnees getC1()
	{
		return super.getPosition(); 
	}

	public Coordonnees getC2()
	{
		Coordonnees newCoord = new Coordonnees (this.getC1().getAbscisse() 
							 + super.getLargeur(), this.getC1().getOrdonnee() 
							 + super.getHauteur());
		return newCoord;
	}
	
	public void setC1(Coordonnees nouvellePosition)
	{
		super.setLargeur(getC2().getAbscisse()-nouvellePosition.getAbscisse()); 
		super.setHauteur(getC2().getOrdonnee()-nouvellePosition.getOrdonnee());
		super.setPosition(nouvellePosition); 
	}
	
	public void setC2 (Coordonnees nouvellePosition)
	{
		this.setLargeur(nouvellePosition.getAbscisse() - this.getC1().getAbscisse());
		this.setHauteur(nouvellePosition.getOrdonnee() - this.getC1().getOrdonnee());
	}
	

	@Override
	public double aire() 
	{
		return 0;
	}

	@Override
	public double perimetre() 
	{
		return this.getC1().distanceVers(this.getC2());
	}
	
	
	public boolean contient(Coordonnees coordonnees) 
	{
		double distC1 = Math.abs(this.getC1().distanceVers(coordonnees));
		double distC2 = Math.abs(this.getC2().distanceVers(coordonnees));
		double distC1C2 = Math.abs(this.getC1().distanceVers(this.getC2()));
		double dist = distC1 + distC2 - distC1C2;
		return(dist <= EPSILON);
	}
	
	
	
	private String vert; 
	
	
	public String toString()
	{
		DecimalFormat dec = new DecimalFormat("0.0#");
		
		double angle = this.getC1().angleVers(getC2());
		if(angle<0) 
		{
			angle = (angle + (2*Math.PI))*360 / (2*Math.PI);
		}
		else 
		{
			angle = angle * (360 /(2*Math.PI));
		}
		if(Locale.getDefault().getLanguage().equals("fr") ) 
		{
			vert = "V";
		}
		else if(Locale.getDefault().getLanguage().equals("en"))
		{
			vert = "G";
		}
		
		String couleur = "couleur = R" 
				+ this.getCouleur().getRed() 
				+ "," + this.vert 
				+ this.getCouleur().getGreen() 
				+ ",B" 
				+ this.getCouleur().getBlue(); 
		
		return "[" + this.getClass().getSimpleName() 
				+ "] c1 : ("
				+ dec.format(this.getC1().getAbscisse()) 
				+ " , "
				+ dec.format(this.getC1().getOrdonnee()) 
				+ ") c2 : ("
				+ dec.format(this.getC2().getAbscisse()) 
				+ " , "
				+ dec.format(this.getC2().getOrdonnee()) 
				+") longueur : "
				+ dec.format( this.perimetre()) 
				+ " angle : " 
				+ dec.format(angle) 
				+ "\u00B0 " 
				+ couleur;
	}
	
	
}
