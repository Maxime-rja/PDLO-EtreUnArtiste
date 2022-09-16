package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEnregistrer extends javax.swing.AbstractAction
{
	 private static final long serialVersionUID = 1L;

	   // class constants
	   public static final String NOM_ACTION = "Enregistrer";
	   
	   // attributes
	   private PanneauDessin panneauDessin;

	   // constructor
	   public ActionEnregistrer(PanneauDessin panneauDessin) 
	   {
	      super(NOM_ACTION);
	      this.panneauDessin=panneauDessin;
	   }

	   //Enregistrer le dessin en jpg et png 
	   public void actionPerformed(ActionEvent event) 
	   {
		   if (event.getActionCommand() == NOM_ACTION) 
			{
			   int answer = JOptionPane.showConfirmDialog(this.panneauDessin, NOM_ACTION + "?", NOM_ACTION, JOptionPane.YES_NO_OPTION);
			   if(answer==0)
			   {
				   BufferedImage monImage = new BufferedImage(panneauDessin.getWidth(), panneauDessin.getHeight(), BufferedImage.TYPE_INT_RGB);
				   Graphics2D gtwo = monImage.createGraphics();
				   panneauDessin.printAll(gtwo);
				   gtwo.dispose();
				   try 
				   {
					   ImageIO.write(monImage, "jpg", new File("MonSuperDessin.jpg"));
					   ImageIO.write(monImage, "png", new File("MonSuperDessin.png"));
				   } 
				   catch (IOException e) 
				   {
					   e.printStackTrace();
				   }
			   }
			}
	   }
}

