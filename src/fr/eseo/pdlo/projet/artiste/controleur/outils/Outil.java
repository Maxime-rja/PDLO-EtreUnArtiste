package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements javax.swing.event.MouseInputListener
{
	private Coordonnees debut, fin; 
	private PanneauDessin panneauDessin; 
	
	public Coordonnees getDebut()
	{
		return this.debut; 
	}
	
	public Coordonnees getFin()
	{
		return this.fin; 
	}
	
	public PanneauDessin getPanneauDessin()
	{
		return this.panneauDessin; 
	}
	
	public void setDebut(Coordonnees debut)
	{
		this.debut = debut; 
	}
	
	public void setFin(Coordonnees fin)
	{
		this.fin = fin; 
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin; 
	}
	
	
	public void mouseClicked(MouseEvent event){}
	public void mouseDragged(MouseEvent event){}
	public void mouseEntered(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
	public void mouseMoved(MouseEvent event){}
	
	 public void mousePressed(MouseEvent event)
	 {
		 this.setDebut(new Coordonnees((double)event.getX(),(double)event.getY()));
	 }
	 
	 
	 public void mouseReleased(MouseEvent event)
	 {
		 setFin(new Coordonnees((double)event.getX(),(double)event.getY()));
	 }
}
