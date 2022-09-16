package fr.eseo.pdlo.projet.artiste.vue.ihm;

//External import
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

//internal import
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class PanneauDessin extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Constant class
	public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 400; 
	public static final java.awt.Color COULEUR_FOND_PAR_DEFAUT = new Color(255, 255, 255);
	
	//attributes
	private final List<VueForme> vueFormes; 
	private Outil outilCourant;
	private Color couleurCourante;
	private Remplissage modeRemplissage; 
	
	//Constructors
	public PanneauDessin()
	{
		super();
		super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT,HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.vueFormes = new ArrayList<VueForme>();
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		
	}
	
	public PanneauDessin(int largeur, int hauteur, java.awt.Color fond)
	{
		super();
		super.setPreferredSize(new Dimension(largeur, hauteur));
	    super.setBackground(fond);
	    this.vueFormes = new ArrayList<VueForme>();
	    this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	    this.modeRemplissage = Remplissage.AUCUNE;   
	}
	
	public PanneauDessin(int largeur, int hauteur)
	{
	      super();
	      super.setPreferredSize(new Dimension(largeur, hauteur));
	      this.vueFormes = new ArrayList<VueForme>();
	      this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
	}
	
	public Remplissage getModeRemplissageCourant()
	{
		return this.modeRemplissage; 
	}
	
	public void setModeRemplissageCourant(Remplissage remplissageMode)
	{
		this.modeRemplissage = remplissageMode; 
	}
	
	public List<VueForme> getVueFormes()
	{
	      return this.vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme)
	{
	      this.vueFormes.add(vueForme);
	}
	
	
	 protected void paintComponent(Graphics g) 
	 {
	      super.paintComponent(g);
	      Graphics2D g2d = (Graphics2D)g.create();
	      for(int i=0; i<this.vueFormes.size(); i++)
	      {
	         vueFormes.get(i).affiche(g2d);
	      }
	      g2d.dispose(); 
	   }
	 
	 
	 //Getters
	 public Outil getOutilCourant()
	 {
	      return this.outilCourant;
	 }
	 
	 //Setters
	 private void setOutilCourant(Outil outil)
	 {
	      this.outilCourant = outil;
	 }
	 
	 
	 public Color getCouleurCourante()
	 {
		 return this.couleurCourante;
	 }
	 
	 
	 public void setCouleurCourante(Color couleurCourante)
	 {
		 this.couleurCourante = couleurCourante;
	 }
	 
	 
	 
	 public void associerOutil(Outil outil)
	 {
	      if(outil==null){}
	      else if(this.getOutilCourant()==null)
	      {
	         setOutilCourant(outil);
	         getOutilCourant().setPanneauDessin(this);
	         this.addMouseListener(outil);
	         this.addMouseMotionListener(outil);
	      } 
	      else 
	      {
	         dissocierOutil();
	         setOutilCourant(outil);
	         getOutilCourant().setPanneauDessin(this);
	         this.addMouseListener(outil);
	         this.addMouseMotionListener(outil);
	      }
	   }
	 
	  private void dissocierOutil()
	  {
	      if(this.getOutilCourant() != null)
	      {
	         if(this.getOutilCourant().getPanneauDessin() != null)
	         {
	        	 this.removeMouseListener(this.getOutilCourant());
	             this.removeMouseMotionListener(this.getOutilCourant());
	        	 getOutilCourant().setPanneauDessin(null);
	             setOutilCourant(null);
	         }
	      }
	   }
}
