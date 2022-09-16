package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class PanneauBarreEtat extends JPanel implements MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	
	private JLabel valeurX; 
	private JLabel valeurY;
	
	private final PanneauDessin panneauDessin; 
	
	public PanneauBarreEtat(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin; 
		valeurX = new JLabel("x: 0"); 
		valeurY = new JLabel("y: 0"); 
		
		this.add(valeurX); 
		this.add(valeurY); 
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		
		panneauDessin.addMouseMotionListener(this);
	}

	
	public void mouseMoved(MouseEvent event) 
	{
		mettreAJourAffichage(new Coordonnees(event.getX(), event.getY())); 
	}
	
	
	public void mouseDragged(MouseEvent event) 
	{
		mettreAJourAffichage(new Coordonnees(event.getX(), event.getY())); 
	}
	
	
	private void mettreAJourAffichage(Coordonnees coords)
	{
		valeurX.setText("x: " + coords.getAbscisse());
		valeurY.setText("y: " + coords.getOrdonnee());
		
		//panneauDessin.repaint(); 
	}
}
