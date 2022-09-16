package fr.eseo.pdlo.projet.artiste.modele.formes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class EllipseTest 
{
	Coordonnees coordonneesDefaut = new Coordonnees();
	
	Ellipse ellipseParDefaut = new Ellipse();
	
	@Test
	public void testConstructeurVide()
	{
		Ellipse ellipseVide = new Ellipse();
		
		assertEquals(coordonneesDefaut.getAbscisse(), ellipseVide.getPosition().getAbscisse(), "Abscisse correct");
		assertEquals(coordonneesDefaut.getOrdonnee(), ellipseVide.getPosition().getOrdonnee(),"Ordonnee correct");
		assertEquals(100.0, ellipseVide.getLargeur(), "Largeur correct");
		assertEquals(150.0, ellipseVide.getHauteur(), "Hauteur correct");
	}
	
	
	@Test
	public void testConstructeurLargHaut()
	{
		Ellipse ellipseLargHaut = new Ellipse(10.0, 20.0);
		
		assertEquals(coordonneesDefaut.getAbscisse(), ellipseLargHaut.getPosition().getAbscisse());
		assertEquals(coordonneesDefaut.getOrdonnee(), ellipseLargHaut.getPosition().getOrdonnee());
		assertEquals(10.0, ellipseLargHaut.getLargeur());
		assertEquals(20.0, ellipseLargHaut.getHauteur());
	}
	
	
	@Test
	public void testConstructorPos()
	{
		Coordonnees point1 = new Coordonnees(1.0, 1.0);
		Ellipse ellipsePos = new Ellipse(point1); 
		
		assertEquals(1.0, ellipsePos.getPosition().getAbscisse());
		assertEquals(1.0,ellipsePos.getPosition().getOrdonnee());
		assertEquals( 100.0, ellipsePos.getLargeur());
		assertEquals(150.0, ellipsePos.getHauteur());
	}
	
	
	@Test
	public void testConstructorPosLargHaut()
	{
		Coordonnees point2 = new Coordonnees(2.0, 2.0);
		Ellipse ellipsePosLarHaut = new Ellipse(point2, 30.0, 35.0);
		
		assertEquals(2.0, ellipsePosLarHaut.getPosition().getAbscisse());
		assertEquals(2.0, ellipsePosLarHaut.getPosition().getOrdonnee());
		assertEquals(30.0, ellipsePosLarHaut.getLargeur());
		assertEquals(35.0, ellipsePosLarHaut.getHauteur());
	}
	
	@Test
	public void setHauteur()
	{
		Ellipse ellipseDefaut = new Ellipse(); 
		ellipseDefaut.setHauteur(5.0);
		
		assertEquals(5.0, ellipseDefaut.getHauteur(), "Hauteur définie");
		assertEquals(100.0, ellipseDefaut.getLargeur(),"Largeur par défaut");
	}
	
	
	@Test
	public void setLargeur()
	{
		Ellipse ellipseDefaut = new Ellipse(); 	
		ellipseDefaut.setLargeur(5.0);

		assertEquals(150.0, ellipseDefaut.getHauteur(), "Hauteur pas défaut");
		assertEquals(5.0, ellipseDefaut.getLargeur(), "Largeur définie");
	}
	

	@Test
	public void testAire()
	{
		Ellipse testEllipse = new Ellipse(34.0, 12.0);
		assertEquals(320.44245066615895, testEllipse.aire());
	}

		
	@Test
	public void testPerimetre()
	{
		Ellipse testEllipse = new Ellipse(34.0, 12.0);
		assertEquals(76.45129387578903, testEllipse.perimetre());
	}
	
	
	@Test
	public void contient()
	{
		Coordonnees point3 = new Coordonnees(3.0,4.0); 
		Ellipse contientEllipse = new Ellipse(34.0, 12.0);
		assertEquals(true, contientEllipse.contient(point3));
	}
	
	@Test
	public void toStringFrance()
	{
		Locale.setDefault(Locale.FRANCE);
		assertEquals("[Ellipse aucune] : pos (0,0 , 0,0) petit rayon 50,0 grand rayon 75,0 "
		+ "périmètre : 396,64 aire : 11780,97 couleur = R51,V51,B51", ellipseParDefaut.toString());
	}
	

	@Test
	public void toStringAnglais() 
	{
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Ellipse aucune] : pos (0.0 , 0.0) petit rayon 50.0 grand rayon 75.0 "
		+ "périmètre : 396.64 aire : 11780.97 couleur = R51,G51,B51", ellipseParDefaut.toString());
	}
	
	// toString other
	@Test
	public void toStringAutre() 
	{
		Locale.setDefault(Locale.CHINA);
		assertEquals("[Ellipse aucune] : pos (0.0 , 0.0) petit rayon 50.0 grand rayon 75.0 "
		+ "périmètre : 396.64 aire : 11780.97 couleur = Mauvaise langue", ellipseParDefaut.toString());
	}
	
	
	@Test
	public void contientBien()
	{
		assertEquals(true,ellipseParDefaut.contient(new Coordonnees(75.0, 75.0)));
	}
	
	@Test
	public void contientPas()
	{
		assertEquals(false,ellipseParDefaut.contient(new Coordonnees(0.0, 0.0)));
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testLargNeg() 
	{
		ellipseParDefaut.setLargeur(-10);
	}
	// hauteur negative
	@Test
	(expected = IllegalArgumentException.class)
	public void testHautNeg() 
	{
		ellipseParDefaut.setHauteur(-10);
	}

	
	@Test
	public void setCouleurE()
	{
		ellipseParDefaut.setCouleur(Color.RED);
		assertEquals(Color.RED, ellipseParDefaut.getCouleur());
	}
}
