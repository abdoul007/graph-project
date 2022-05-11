package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Sommet {

	protected int id = 0 ;
	protected String Nom;
	
	
	
	public Sommet( String Nom) {
		// TODO Auto-generated constructor stub
		
		this.Nom = Nom;
		if (Nom == null) this.Nom = "";
		id++;
		
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	


	
	
}

