package fr.eseo.pdlo.projet.artiste.modele.formes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class RectangleTest 
{
	Coordonnees coordonneesDefaut = new Coordonnees();
	
	Rectangle rectangleParDefaut = new Rectangle();
	
	@Test
	public void testConstructeurVide()
	{
		Rectangle rectangleVide = new Rectangle();
		
		assertEquals(coordonneesDefaut.getAbscisse(), rectangleVide.getPosition().getAbscisse(), "Abscisse correct");
		assertEquals(coordonneesDefaut.getOrdonnee(), rectangleVide.getPosition().getOrdonnee(),"Ordonnee correct");
		assertEquals(100.0, rectangleVide.getLargeur(), "Largeur correct");
		assertEquals(150.0, rectangleVide.getHauteur(), "Hauteur correct");
	}
	
	
	@Test
	public void testConstructeurLargHaut()
	{
		Rectangle rectangleLargHaut = new Rectangle(10.0, 20.0);
		
		assertEquals(coordonneesDefaut.getAbscisse(), rectangleLargHaut.getPosition().getAbscisse());
		assertEquals(coordonneesDefaut.getOrdonnee(), rectangleLargHaut.getPosition().getOrdonnee());
		assertEquals(10.0, rectangleLargHaut.getLargeur());
		assertEquals(20.0, rectangleLargHaut.getHauteur());
	}
	
	
	@Test
	public void testConstructorPos()
	{
		Coordonnees point1 = new Coordonnees(1.0, 1.0);
		Rectangle rectanglePos = new Rectangle(point1); 
		
		assertEquals(1.0, rectanglePos.getPosition().getAbscisse());
		assertEquals(1.0,rectanglePos.getPosition().getOrdonnee());
		assertEquals( 100.0, rectanglePos.getLargeur());
		assertEquals(150.0, rectanglePos.getHauteur());
	}
	
	
	@Test
	public void testConstructorPosLargHaut()
	{
		Coordonnees point2 = new Coordonnees(2.0, 2.0);
		Rectangle rectanglePosLarHaut = new Rectangle(point2, 30.0, 35.0);
		
		assertEquals(2.0, rectanglePosLarHaut.getPosition().getAbscisse());
		assertEquals(2.0, rectanglePosLarHaut.getPosition().getOrdonnee());
		assertEquals(30.0, rectanglePosLarHaut.getLargeur());
		assertEquals(35.0, rectanglePosLarHaut.getHauteur());
	}
	
	@Test
	public void setHauteur()
	{
		Rectangle rectangleDefaut = new Rectangle(); 
		rectangleDefaut.setHauteur(5.0);
		
		assertEquals(5.0, rectangleDefaut.getHauteur(), "Hauteur définie");
		assertEquals(100.0, rectangleDefaut.getLargeur(),"Largeur par défaut");
	}
	
	
	@Test
	public void setLargeur()
	{
		Rectangle rectangleDefaut = new Rectangle(); 	
		rectangleDefaut.setLargeur(5.0);

		assertEquals(150.0, rectangleDefaut.getHauteur(), "Hauteur pas défaut");
		assertEquals(5.0, rectangleDefaut.getLargeur(), "Largeur définie");
	}
	

	@Test
	public void testAire()
	{
		Ellipse testRectangle = new Ellipse(34.0, 12.0);
		assertEquals(320.44245066615895, testRectangle.aire());
	}

		
	@Test
	public void testPerimetre()
	{
		Ellipse testRectangle = new Ellipse(34.0, 12.0);
		assertEquals(76.45129387578903, testRectangle.perimetre());
	}
	
	
	@Test
	public void contient()
	{
		Coordonnees point3 = new Coordonnees(3.0,4.0); 
		Rectangle contientRectangle = new Rectangle(34.0, 12.0);
		assertEquals(true, contientRectangle.contient(point3));
	}
	
	@Test
	public void toStringFrance()
	{
		Locale.setDefault(Locale.FRANCE);
		assertEquals("[Rectangle aucune] : pos (0,0 , 0,0) dim 100,0 x 150,0 périmètre "
		+ ": 500,0 aire : 15000,0 couleur = R51,V51,B51", rectangleParDefaut.toString());
	}
	

	@Test
	public void toStringAnglais() 
	{
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Rectangle aucune] : pos (0.0 , 0.0) dim 100.0 x 150.0 périmètre "
		+ ": 500.0 aire : 15000.0 couleur = R51,G51,B51", rectangleParDefaut.toString());
	}
	
	// toString other
	@Test
	public void toStringAutre() 
	{
		Locale.setDefault(Locale.CHINA);
		assertEquals("[Rectangle aucune] : pos (0.0 , 0.0) dim 100.0 x 150.0 périmètre "
		+ ": 500.0 aire : 15000.0 couleur = Mauvaise langue", rectangleParDefaut.toString());
	}
	
	
	@Test
	public void contientBien()
	{
		assertEquals(true,rectangleParDefaut.contient(new Coordonnees(75.0, 75.0)));
	}
	
	@Test
	public void contientPas()
	{
		assertEquals(false,rectangleParDefaut.contient(new Coordonnees(0.0, 0.0)));
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testLargNeg() 
	{
		rectangleParDefaut.setLargeur(-10);
	}
	
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testHautNeg() 
	{
		rectangleParDefaut.setHauteur(-10);
	}

	
	@Test
	public void setCouleurE()
	{
		rectangleParDefaut.setCouleur(Color.RED);
		assertEquals(Color.RED, rectangleParDefaut.getCouleur());
	}
}

