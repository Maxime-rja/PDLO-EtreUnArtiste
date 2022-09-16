package fr.eseo.pdlo.projet.artiste.modele;

public enum Remplissage 
{
	AUCUNE("aucune"), UNIFORME("uniforme"); 
		
	private String abreviation; 
		
	private Remplissage(String mode)
	{
		this.abreviation = mode; 
	}
	
	public String getMode()
	{
		return this.abreviation; 
	}
}

