package classes;

import java.util.ArrayList;
import java.util.List;

public class PageAccount extends Sommet {

	private List<UserAccount> admins ;
	private List<UserAccount> abonnees ;
	
	public PageAccount(String Nom) {
		super(Nom);
		// TODO Auto-generated constructor stub
		admins = new ArrayList<UserAccount>();
		abonnees = new ArrayList<UserAccount>();
	}
	
	public List<UserAccount> getAdmins() {
		return admins;
	}
	
	public List<UserAccount> getAbonnees() {
		return abonnees;
	}


	public String infos() {
		
		return "le nom de la page est : " + Nom +
				"\n Le nombre des abonnees est :" + abonnees.size() + 
				"\n Le nombre des admins est : " + admins.size();
	}


	
	
}
