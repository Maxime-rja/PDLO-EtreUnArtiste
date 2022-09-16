package fr.eseo.pdlo.projet.artiste.modele.formes;



import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable
{
	public static final double LARGEUR_PAR_DEFAUT = 100.0;
	public static final double HAUTEUR_PAR_DEFAUT = 150.0;
	public static final Coordonnees POSITION_PAR_DEFAUT = new Coordonnees(); 
	public static final double EPSILON = 0.2;
	
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	
	private double largeur;  
	private double hauteur;
	
	private Coordonnees position;
	
	private Color couleur;
	
	
	//Constructors
	
	public Forme ()
	{
		this (POSITION_PAR_DEFAUT, LARGEUR_PAR_DEFAUT ,HAUTEUR_PAR_DEFAUT );
	}
	
	public Forme (Coordonnees position, double largeur , double hauteur )
	{
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		setCouleur(this.COULEUR_PAR_DEFAUT); 
	}
	
	public Forme ( double largeur , double hauteur )
	{
		this (POSITION_PAR_DEFAUT, largeur, hauteur );
	}
	
	public Forme ( Coordonnees position )
	{
		this (position , LARGEUR_PAR_DEFAUT , HAUTEUR_PAR_DEFAUT );
	}
	
	
	//Getters
	public Coordonnees getPosition() 
	{
		return position;
	}

	public double getLargeur() 
	{
		return this.largeur;
	}
	
	public double getHauteur() 
	{
		return hauteur;
	}
	
	public Color getCouleur()
	{
		return this.couleur;
	}
	
	
	//Setters
	public void setPosition(Coordonnees pos) 
	{
		this.position = pos;
	}
	
	public void setLargeur(double largeur) 
	{
		this.largeur = largeur;
	}


	public void setHauteur(double hauteur) 
	{
		this.hauteur = hauteur;
	}

	
	public void setCouleur(Color couleur)
	{
		this.couleur = couleur;
	}
	
	public double getCadreMinX()
	{
		return Math.min(position.getAbscisse() + this.largeur , position.getAbscisse()); 
	}
	
	
	public double getCadreMinY()
	{
		return Math.min(position.getOrdonnee() + this.hauteur , position.getOrdonnee());
	}
	
	public double getCadreMaxX()
	{
		return Math.max(position.getAbscisse() + this.largeur,position.getAbscisse());
	}
	
	
	public double getCadreMaxY()
	{
		return Math.max(position.getOrdonnee() + this.hauteur , position.getOrdonnee());
	}
	
	public void deplacerDe(double nouvelleAbscisse, double nouvelleOrdonnee) 
	{
		this.position.setAbscisse(this.position.getAbscisse() + nouvelleAbscisse);
		this.position.setOrdonnee(this.position.getOrdonnee() + nouvelleOrdonnee);
	}
	
	
	public void deplacerVers(double deltaX, double deltaY ) 
	{
		this.position.setAbscisse(deltaX);
		this.position.setOrdonnee(deltaY);
	}
	
	public abstract double aire(); 
	
	
	public abstract double perimetre();
	
	public abstract boolean contient(Coordonnees coordonnees);
	
}


