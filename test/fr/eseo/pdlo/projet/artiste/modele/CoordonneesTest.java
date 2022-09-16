package fr.eseo.pdlo.projet.artiste.modele;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest 
{

	@Test
	public void testConstructeur0() 
	{
		Coordonnees test0 = new Coordonnees(); 
		assertEquals( 0 , test0.getAbscisse(), "Coordonnees abscisse attendu");
		assertEquals( 0 , test0.getOrdonnee(), "Coordonnees ordonnees attendu");
	}
	
	@Test
	public void testConstructeur1() 
	{
		Coordonnees test1 = new Coordonnees(1,2); 
		assertEquals( 1 , test1.getAbscisse(), "Coordonnees abscisse attendu");
		assertEquals( 2 , test1.getOrdonnee(), "Coordonnees ordonnees attendu");
	}
	
	@Test
	public void getAbscisse()
	{ 	 
		Coordonnees pointXY = new Coordonnees(3.0,4.0);
		assertEquals(3.0, pointXY.getAbscisse() , "Largeur correct");
	}
	
	@Test
	public void getOrdonnee()
	{ 	 
		Coordonnees pointXY = new Coordonnees(3.0,4.0);
		assertEquals(4.0, pointXY.getOrdonnee() , "Ordonnee Correct");
	}
	
	@Test
	public void setAbscisse()
	{ 	 
		Coordonnees pointDefault = new Coordonnees();
		pointDefault.setAbscisse(6.0);
		
		assertEquals(6.0, pointDefault.getAbscisse(), "Abscisse correct");
	}
	
	
	@Test
	public void setOrdonnee()
	{ 	 
		Coordonnees pointDefault = new Coordonnees();
		pointDefault.setOrdonnee(1.0);
		
		assertEquals(1.0, pointDefault.getOrdonnee() , "Ordonnee Correct");
	}
	
	
	@Test
	public void afficherCoord()
	{ 	 
		Coordonnees pointAffiche = new Coordonnees(9.0,7.0);
		assertEquals("Les coordonnees du point sont X : 9.0 Y : 7.0", pointAffiche.afficherCoord());
	}
	
	
	@Test
	public void versChaine()
	{ 	 
		Coordonnees pointChaine = new Coordonnees(6.0,5.0);
		assertEquals("(6.0,5.0)", pointChaine.versChaine());
	}
	
	@Test
	public void toStringt()
	{ 	 
		Coordonnees pointString = new Coordonnees(3.0,4.0);
		assertEquals("(3,0 , 4,0)", pointString.toString());
	}
	
	
	@Test
	public void testDeplacerVers() 
	{
		Coordonnees test3 = new Coordonnees (0,0);
		assertEquals( 0 , test3.getAbscisse(), "Coordonnees abscisse attendu");
		assertEquals( 0 , test3.getOrdonnee(), "Coordonnees ordonnees attendu");
		
		test3.deplacerVers(1,3)	;
		assertEquals( 1 , test3.getAbscisse(), "Coordonnees abscisse attendu");
		assertEquals( 3 , test3.getOrdonnee(), "Coordonnees ordonnees attendu");
	}
	
	
	@Test
	public void testDeplacerDe() 
	{
		Coordonnees test4 = new Coordonnees (1,1);
		
		test4.deplacerDe(1,3)	;
		assertEquals( 2 , test4.getAbscisse(), "Déplacement correct en abscisse");
		assertEquals( 4 , test4.getOrdonnee(), "Déplacement correct en ordonnée");
	}
	
	@Test
	public void testDistanceVers() 
	{
		Coordonnees coordonnees1 = new Coordonnees (0,10);
		Coordonnees coordonnees2 = new Coordonnees (10,10);

		assertEquals( 10 , coordonnees1.distanceVers(coordonnees2), "Distance correct");
	}
	
	@Test
	public void angleVers() 
	{
		Coordonnees coordonnees3 = new Coordonnees (0,0);
		
		Coordonnees coordonnees4 = new Coordonnees (0,1);
		assertEquals( Math.PI/2 , coordonnees3.angleVers(coordonnees4), "-pi/2 attendu");
		
		Coordonnees coordonnees5 = new Coordonnees (0,-1);
		assertEquals( -Math.PI/2 , coordonnees3.angleVers(coordonnees5), "pi/2 attendu");
	
		Coordonnees coordonnees6 = new Coordonnees (1,0);
		assertEquals( 0  , coordonnees3.angleVers(coordonnees6), "0 attendu");
		
		Coordonnees coordonnees7 = new Coordonnees (-1,0);
		assertEquals(  Math.PI , coordonnees3.angleVers(coordonnees7), "pi attendu");
		
		Coordonnees coordonnees8 = new Coordonnees (1,1);
		assertEquals(  Math.PI/4 , coordonnees3.angleVers(coordonnees8), "-pi/4 attendu");
		
		Coordonnees coordonnees9 = new Coordonnees (1,-1);
		assertEquals(  -Math.PI/4 , coordonnees3.angleVers(coordonnees9), "pi/4 attendu");
		
		Coordonnees coordonnees10 = new Coordonnees (-1,1);
		assertEquals(  3*Math.PI/4 , coordonnees3.angleVers(coordonnees10), "3pi/4 attendu");
		
		Coordonnees coordonnees11 = new Coordonnees (-1,-1);
		assertEquals(  -3*Math.PI/4 , coordonnees3.angleVers(coordonnees11), "-3pi/4 attendu");
		
	}
	
	
}
