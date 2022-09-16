package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest 
{
	Coordonnees coordonneesDefaut = new Coordonnees();
	Cercle cercleParDefaut = new Cercle();
	
	
	@Test
	public void testConstructeurVide()
	{
		Cercle cercleVide = new Cercle();
		
		assertEquals(coordonneesDefaut.getAbscisse(), cercleVide.getPosition().getAbscisse(), "Abscisse correct");
		assertEquals(coordonneesDefaut.getOrdonnee(), cercleVide.getPosition().getOrdonnee(),"Ordonnee correct");
		assertEquals(100.0, cercleVide.getLargeur(), "Largeur correct");
		assertEquals(100.0, cercleVide.getHauteur(), "Hauteur correct");
	}
	
	
	@Test
	public void testConstructeurTaille()
	{
		Cercle cercleTaille = new Cercle(10.0);
		
		assertEquals(coordonneesDefaut.getAbscisse(), cercleTaille.getPosition().getAbscisse());
		assertEquals(coordonneesDefaut.getOrdonnee(), cercleTaille.getPosition().getOrdonnee());
		assertEquals(10.0, cercleTaille.getLargeur());
		assertEquals(10.0, cercleTaille.getHauteur());
	}
	
	
	@Test
	public void testConstructorPos()
	{
		Coordonnees point1 = new Coordonnees(1.0, 1.0);
		Cercle cerclePos = new Cercle(point1); 
		
		assertEquals(1.0, cerclePos.getPosition().getAbscisse());
		assertEquals(1.0,cerclePos.getPosition().getOrdonnee());
		assertEquals(100.0, cerclePos.getLargeur());
		assertEquals(100.0, cerclePos.getHauteur());
	}
	
	
	@Test
	public void testConstructorPosTaille()
	{
		Coordonnees point2 = new Coordonnees(2.0, 2.0);
		Cercle cerclePosTaille = new Cercle(point2, 30.0);
		
		assertEquals(2.0, cerclePosTaille.getPosition().getAbscisse());
		assertEquals(2.0, cerclePosTaille.getPosition().getOrdonnee());
		assertEquals(30.0, cerclePosTaille.getLargeur());
		assertEquals(30.0, cerclePosTaille.getHauteur());
	}
	
	
	Cercle cercleDefaut = new Cercle(); 
	@Test
	public void setHauteur()
	{	
		cercleDefaut.setHauteur(5.0);
		
		assertEquals(5.0, cercleDefaut.getHauteur(), "Largeur Correct");
		assertEquals(5.0, cercleDefaut.getLargeur(), "Largeur correct");
	}
	
	
	@Test
	public void setLargeur()
	{ 	
		cercleDefaut.setLargeur(5.0);

		assertEquals(5.0, cercleDefaut.getLargeur(), "Largeur correct");
		assertEquals(5.0, cercleDefaut.getLargeur(), "Largeur correct");
	}
	

	@Test
	public void testAire()
	{
		Cercle aireCercle = new Cercle(34.0);
		assertEquals(907.9202768874502, aireCercle.aire());
	}

		
	@Test
	public void testPerimetre()
	{
		Cercle perimetreCercle = new Cercle(34.0);
		assertEquals(106.81415022205297, perimetreCercle.perimetre());
	}

	
	@Test
	public void toStringFrancais()
	{
		Locale.setDefault(Locale.FRANCE);
		assertEquals("[Cercle aucune] : pos (0,0 , 0,0) rayon 50,0 "
				+ "périmètre : 314,16 aire : 7853,98 couleur = R51,V51,B51", cercleParDefaut.toString());
	}

		
	@Test
	public void toStringAnglais() 
	{
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Cercle aucune] : pos (0.0 , 0.0) rayon 50.0 "
				+ "périmètre : 314.16 aire : 7853.98 couleur = R51,G51,B51", cercleParDefaut.toString());
	}
		
		
		
	@Test
	public void toStringAutre() 
	{
		Locale.setDefault(Locale.CHINA);
		assertEquals("[Cercle aucune] : pos (0.0 , 0.0) rayon 50.0 "
				+ "périmètre : 314.16 aire : 7853.98 couleur = Mauvaise langue", cercleParDefaut.toString());
	}
}
