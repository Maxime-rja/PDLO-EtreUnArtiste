package fr.eseo.pdlo.projet.artiste.vue.formes;

//external imports
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public abstract class VueForme 
{
	//attributes 
	protected final Forme forme; 
	
	
	//Constructor
	public VueForme(Forme forme)
	{
		this.forme = forme; 
	}
	
	//getter
	public Forme getForme()
	{
		return this.forme; 
	}
	
	
	public abstract void affiche(Graphics2D g2d); 
	
}
