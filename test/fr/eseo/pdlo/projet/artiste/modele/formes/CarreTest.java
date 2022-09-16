package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CarreTest 
{
	Coordonnees coordonneesDefaut = new Coordonnees();
	Carre carreParDefaut = new Carre();
	
	
	@Test
	public void testConstructeurVide()
	{
		Cercle carreVide = new Cercle();
		
		assertEquals(coordonneesDefaut.getAbscisse(), carreVide.getPosition().getAbscisse(), "Abscisse correct");
		assertEquals(coordonneesDefaut.getOrdonnee(), carreVide.getPosition().getOrdonnee(),"Ordonnee correct");
		assertEquals(100.0, carreVide.getLargeur(), "Largeur correct");
		assertEquals(100.0, carreVide.getHauteur(), "Hauteur correct");
	}
	
	
	@Test
	public void testConstructeurTaille()
	{
		Carre carreTaille = new Carre(10.0);
		
		assertEquals(coordonneesDefaut.getAbscisse(), carreTaille.getPosition().getAbscisse());
		assertEquals(coordonneesDefaut.getOrdonnee(), carreTaille.getPosition().getOrdonnee());
		assertEquals(10.0, carreTaille.getLargeur());
		assertEquals(10.0, carreTaille.getHauteur());
	}
	
	
	@Test
	public void testConstructorPos()
	{
		Coordonnees point1 = new Coordonnees(1.0, 1.0);
		Carre carrePos = new Carre(point1); 
		
		assertEquals(1.0, carrePos.getPosition().getAbscisse());
		assertEquals(1.0,carrePos.getPosition().getOrdonnee());
		assertEquals(100.0, carrePos.getLargeur());
		assertEquals(150.0, carrePos.getHauteur());
	}
	
	
	@Test
	public void testConstructorPosTaille()
	{
		Coordonnees point2 = new Coordonnees(2.0, 2.0);
		Carre carrePosTaille = new Carre(point2, 30.0);
		
		assertEquals(2.0, carrePosTaille.getPosition().getAbscisse());
		assertEquals(2.0, carrePosTaille.getPosition().getOrdonnee());
		assertEquals(30.0, carrePosTaille.getLargeur());
		assertEquals(30.0, carrePosTaille.getHauteur());
	}
	
	
	Carre carreDefaut = new Carre(); 
	@Test
	public void setHauteur()
	{	
		carreDefaut.setHauteur(5.0);
		
		assertEquals(5.0, carreDefaut.getHauteur(), "Largeur Correct");
		assertEquals(5.0, carreDefaut.getLargeur(), "Largeur correct");
	}
	
	
	@Test
	public void setLargeur()
	{ 	
		carreDefaut.setLargeur(5.0);

		assertEquals(5.0, carreDefaut.getLargeur(), "Largeur correct");
		assertEquals(5.0, carreDefaut.getLargeur(), "Largeur correct");
	}
	

	@Test
	public void testAire()
	{
		Carre aireCarre = new Carre(34.0);
		assertEquals(1156.0, aireCarre.aire());
	}

		
	@Test
	public void testPerimetre()
	{
		Carre perimetreCarre = new Carre(34.0);
		assertEquals(136.0, perimetreCarre.perimetre());
	}

	
	@Test
	public void toStringFrancais()
	{
		Locale.setDefault(Locale.FRANCE);
		assertEquals("[Carré aucune] : pos (0,0 , 0,0) dim 100,0 x 150,0 périmètre "
		+ ": 400,0 aire : 10000,0 couleur = R51,V51,B51", carreParDefaut.toString());
	}

		
	@Test
	public void toStringAnglais() 
	{
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Carré aucune] : pos (0.0 , 0.0) dim 100.0 x 150.0 périmètre "
		+ ": 400.0 aire : 10000.0 couleur = R51,G51,B51", carreParDefaut.toString());
	}
		
		
		
	@Test
	public void toStringAutre() 
	{
		Locale.setDefault(Locale.CHINA);
		assertEquals("[Carré aucune] : pos (0.0 , 0.0) dim 100.0 x 150.0 périmètre : 400.0 aire "
		+ ": 10000.0 couleur = Mauvaise langue", carreParDefaut.toString());
	}
}
