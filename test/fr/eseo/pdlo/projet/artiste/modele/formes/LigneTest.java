package fr.eseo.pdlo.projet.artiste.modele.formes;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest 
{
	public static final double EPSILON = 0.2;
	Coordonnees coordonneesDefaut = new Coordonnees();
	Ligne ligneParDefaut = new Ligne();

	@Test
	public void testConstructeurVide() {
		Ligne ligneVide = new Ligne();
		assertEquals(100.0, ligneVide.getLargeur(), EPSILON, "Largeur attendue");
		assertEquals(150.0,  ligneVide.getHauteur(), EPSILON, "Hauteur attendue");
	}
	
	@Test
	void testConstructeurPos() {
		Coordonnees point1 = new Coordonnees(1.0, 2.0);
		Ligne ligneCoord = new Ligne(point1);
		
		assertEquals(100.0, ligneCoord.getLargeur(), EPSILON, "Largeur attendue");
		assertEquals(150.0, ligneCoord.getHauteur(), EPSILON, "Hauteur attendue");
		assertEquals(1.0, point1.getAbscisse(), EPSILON, "Position x attendue");
		assertEquals(2.0, point1.getOrdonnee(), EPSILON, "Position y attendue");
	}

	@Test
	void testConstructeurLarHaut() {
		Ligne ligneHautLarg = new Ligne(30, 40);
		assertEquals(30, ligneHautLarg.getLargeur(), EPSILON, "Largeur attendue");
		assertEquals(40, ligneHautLarg.getHauteur(), EPSILON, "Hauteur attendue");
	}

	@Test
	void testConstructeurPosLargHaut() {
		Ligne ligneCoordHautLarg = new Ligne(10, 20);
		Coordonnees point2 = new Coordonnees(3, 4);
		assertEquals(10, ligneCoordHautLarg.getLargeur(), EPSILON, "Largeur attendue");
		assertEquals(20, ligneCoordHautLarg.getHauteur(), EPSILON, "Hauteur attendue");
		assertEquals(3, point2.getAbscisse(), EPSILON, "Position x attendue");
		assertEquals(4, point2.getOrdonnee(), EPSILON, "Position y attendue");
	}

	@Test
	void testAire() {
		Ligne ligneAire = new Ligne();
		assertEquals(0, ligneAire.aire(), EPSILON, "Aire attendue");
	}

	@Test
	void testPerimetre() {
		Coordonnees point3 = new Coordonnees(5, 6);
		Ligne lignePerimetre = new Ligne(point3, 2, 2);
		assertEquals(2.8284271247461903, lignePerimetre.perimetre(), EPSILON, "Perimétre attendu");
	}
	
	@Test
	public void getC1()
	{
		Coordonnees point4 = new Coordonnees(4.0, 8.0);
		Ligne ligneC1 = new Ligne(point4);
		
		assertEquals(4.0 , ligneC1.getC1().getAbscisse(), EPSILON);
		assertEquals(8.0 , ligneC1.getC1().getOrdonnee(), EPSILON);
	}
	
	
	@Test
	public void getC2()
	{
		Coordonnees pointC2 = new Coordonnees(4, 8);
		Ligne ligneC2 = new Ligne(pointC2, 2.0, 3.0);

		
		assertEquals(6.0, ligneC2.getC2().getAbscisse(), EPSILON);
		assertEquals(11.0, ligneC2.getC2().getOrdonnee(), EPSILON);
	}
	
	
	@Test
	public void setC1()
	{
		Coordonnees point4 = new Coordonnees(4, 8);
		Ligne ligneDefaut = new Ligne();
		
		ligneDefaut.setC1(point4);
		
		assertEquals(point4.getAbscisse(), ligneDefaut.getC1().getAbscisse(), EPSILON);
		assertEquals(point4.getOrdonnee(), ligneDefaut.getC1().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void setC2()
	{
		Coordonnees point4 = new Coordonnees(4, 8);
		Ligne ligneDefaut = new Ligne();
		
		ligneDefaut.setC2(point4);
		
		assertEquals(point4.getAbscisse(), ligneDefaut.getC2().getAbscisse(), EPSILON);
		assertEquals(point4.getOrdonnee(), ligneDefaut.getC2().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void setCouleurT()
	{
		Ligne ligne = new Ligne();
		ligne.setCouleur(Color.RED);
		assertEquals(Color.RED, ligne.getCouleur());
	}

	
	@Test
	public void toStringFR()
	{
		Coordonnees pointString = new Coordonnees(4.0, 8.0);
		Ligne ligneString = new Ligne(pointString, 2.0, 3.0);
		Locale.setDefault(Locale.FRANCE);
		assertEquals("[Ligne] c1 : (4,0 , 8,0) c2 : (6,0 , 11,0) longueur : 3,61 angle : 56,31° couleur = R51,V51,B51", 
		ligneString.toString());
	}
	
	
	@Test
	public void contient()
	{
		Coordonnees pointContient = new Coordonnees(7.0, 8.0);
		Ligne ligneContient = new Ligne(pointContient, 2.0, 1.0);
		
		assertEquals(true, ligneContient.contient(pointContient));
	}
	
	@Test
	public void contientPas()
	{
		Coordonnees pointContientPas = new Coordonnees(2.0, 2.0);
		Coordonnees compare = new Coordonnees(75.0, 75.0);
		Ligne testLigne = new Ligne(pointContientPas, 1.0, 1.0);
		assertEquals(false, testLigne.contient(compare));
	}
	
	
	@Test
	public void toStringt()
	{
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		Locale.setDefault(Locale.FRANCE);
		ligneParDefaut.setC1(coord);
		ligneParDefaut.setC2(coordonneesDefaut);
		assertEquals("[Ligne] c1 : (3,0 , 3,0) c2 : (0,0 , 0,0) longueur : 4,24 angle : 225,0° couleur = R51,V51,B51",
		ligneParDefaut.toString());
	}
	
	
	
	@Test
	public void toStringEn()
	{
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		Locale.setDefault(Locale.ENGLISH);
		ligneParDefaut.setC1(coord);
		ligneParDefaut.setC2(coordonneesDefaut);
		assertEquals("[Ligne] c1 : (3.0 , 3.0) c2 : (0.0 , 0.0) longueur : 4.24 angle : 225.0° couleur = R51,G51,B51",
		ligneParDefaut.toString());
	}
	
	
	// toString other
	@Test
	public void toStringOther()
	{
		Coordonnees coord = new Coordonnees(3.0, 3.0);
		Locale.setDefault(Locale.CHINA);
		ligneParDefaut.setC1(coord);
		ligneParDefaut.setC2(coordonneesDefaut);
		assertEquals("[Ligne] c1 : (3.0 , 3.0) c2 : (0.0 , 0.0) longueur : 4.24 angle : 225.0° couleur = R51,null51,B51",
		ligneParDefaut.toString());
	}
	

	@Test
	public void testGetCadreMinY() 
	{
		Ligne ligne = new Ligne(new Coordonnees(15, 30), 30, 40);
		assertEquals(30.0, ligne.getCadreMinY());
	}
	

	@Test
	public void testGetCadreMinX() 
	{
		Ligne ligne = new Ligne(new Coordonnees(15, 30), 30, 40);
		assertEquals(15.0, ligne.getCadreMinX());
	}
	

	@Test
	public void testGetCadreMaxY() 
	{
		Ligne ligne = new Ligne(new Coordonnees(15, 30), 30, 40);
		assertEquals(70.0, ligne.getCadreMaxY());
	}
	

	@Test
	public void testGetCadreMaxX() 
	{
		Ligne ligne = new Ligne(new Coordonnees(15, 30), 30, 40);
		assertEquals(45.0, ligne.getCadreMaxX());
	}
}
