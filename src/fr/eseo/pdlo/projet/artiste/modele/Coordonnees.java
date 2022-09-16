package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees 
{
	double abscisse;
	double ordonnee;
	
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;
	
	public Coordonnees()
	{
		this.abscisse = ABSCISSE_PAR_DEFAUT;
		this.ordonnee = ORDONNEE_PAR_DEFAUT;
	}
	
	public Coordonnees(double abscisse, double ordonnee) 
	{
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	
	public double getAbscisse() 
	{
		return abscisse;
	}
	
	public double getOrdonnee() 
	{
		return ordonnee ;
	}
	
	
	
	public void setAbscisse(double abscisse) 
	{
		this.abscisse = abscisse;
	}
	
	public void setOrdonnee(double ordonnee) 
	{
		this.ordonnee = ordonnee;
	}
	
	
	
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) 
	{
		this.abscisse = nouvelleAbscisse;
		this.ordonnee = nouvelleOrdonnee;
	}
	
	
	public void deplacerDe(double deltaX, double deltaY ) 
	{
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}
	
	
	public double distanceVers(Coordonnees point) 
	{
		return Math.sqrt(Math.pow(point.getAbscisse() - this.getAbscisse(), 2) 
			   + Math.pow(point.getOrdonnee() - this.getOrdonnee(), 2));
	}
	
	
	public double angleVers(Coordonnees point) 
	{
		return Math.atan2(point.getOrdonnee() - this.getOrdonnee(), point.getAbscisse()- this.getAbscisse());
	}
	
	
	public String afficherCoord() 
	{
		return "Les coordonnees du point sont X : " + this.abscisse + " Y : " + this.ordonnee;
	}
	
	
	public String versChaine() 
	{
		return "(" + this.getAbscisse() + "," + this.getOrdonnee() + ")";
	}
	

	public String toString() 
	{
		DecimalFormat decimalFormat = new DecimalFormat("0.0#"); 
		return "(" + decimalFormat.format(abscisse) + " , " + decimalFormat.format(ordonnee) + ")";
	}
	
}

