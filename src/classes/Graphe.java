package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Graphe {
	
    public  static Map<UserAccount, List<Sommet>> relations = new HashMap<UserAccount, List<Sommet>>();
	public static List<Sommet> listSommet = new ArrayList<Sommet>();
	
	// obtenir l'ensemble des sommets trie par Nom:
	public static List<String> Ensemble_Sommet_Nom() {
		List<String> l = new ArrayList<String>();
		for (Sommet s : listSommet) l.add(s.getNom());
		return l;
		
	}
	// ajouter un sommet:
	public static void AddSommet(Sommet s) {
		
		if (s != null && !Ensemble_Sommet_Nom().contains(s.getNom())) {
			listSommet.add(s);
			if (s instanceof UserAccount) relations.put((UserAccount) s, new ArrayList<Sommet>());
		}
		
		
	}
	
	// ajouter un arc :
	public static void AddArc(Sommet s, Sommet d) {
		if (s == null || d == null) return;
		if (!s.getNom().equals(d.getNom()) && s instanceof UserAccount && Ensemble_Sommet_Nom().contains(s.getNom())
				&& Ensemble_Sommet_Nom().contains(d.getNom())
				&& !relations.get(s).contains(d))
			relations.get(s).add(d);
	}
	
	public static Sommet getSommet(String s) {
		if (s == null || !Ensemble_Sommet_Nom().contains(s)) return null;
		return listSommet.get(Ensemble_Sommet_Nom().indexOf(s));
	}
	
	// obtenir le nombre des sommets:
	public static int Nb_Sommet() {
		return listSommet.size();
	}
	// obtenir le nombre d'arcs:
	public static int Nb_Arcs() {
		int nb = 0;
		for (Sommet s : relations.keySet()) nb += relations.get(s).size();
		return nb;	
	}
	
	//
	// trier sommets par degre sortant:
	public List<Sommet> Sommet_trie_degre() {
		
		NavigableMap<Integer, Sommet> k = new TreeMap<Integer, Sommet>();
    	for(Sommet s : listSommet) {
    		k.put(nb_sortant(s), s);
    	}
		return (List<Sommet>) k.values();		
	}

	// obtenir l'ensemble d'arcs
	public Map<UserAccount, List<Sommet>> Ensemble_arc(){
		return relations;
	}
	// supprimer un sommet:
	public static void Delete_Sommet(Sommet s) {
		// if (s == null) return;
		relations.remove(s);
		listSommet.remove(s);
		for (Sommet sm : relations.keySet()) relations.get(sm).remove(s);
	}
	// supprimer un arc:
	public static void Delete_Arc(Sommet s, Sommet d) {
		if (s == null || d == null) return;
		relations.get(s).remove(d);
	}
	// obtenir des infos sur un sommet via son nom:
    public static String Sommet_info(String Nom) {
		for(Sommet r : listSommet) {
			if(r.Nom == Nom) {
				if(r instanceof UserAccount) {
					return ((UserAccount) r).infos();
				}
				else {
					return ((PageAccount) r).infos();
				}		
			}			
	     }
		return "Sommet doesn't exist";
	}
    
    //connaitre le nombre de compte de type utilisateur:
    public static int nb_user_account() {
		return relations.size();
    }
    
  //connaitre le nombre de compte de type page:
    public static int nb_page_account() {
    	
    	int nombre = 0;
    	
    	for(Sommet r : listSommet) {
			if(r instanceof PageAccount) {
				nombre++;
			}
    	}
		return nombre;
    }

    // connaitre l'age moyen des utilisateurs:
    public static double age_moyen () {
    	int somme_age = 0;
    	for (UserAccount s : relations.keySet()) somme_age += s.getAge();
    	return (double) somme_age / nb_user_account();
    }
    
    // connaitre tous les comptes utilisateurs admin:
    public Set<Sommet> admins_users(List<Sommet> s){
    	List<Sommet> admins = new ArrayList<Sommet>();
    	for(Sommet r : s) {
	    	if(r instanceof PageAccount) {
	    		for(UserAccount u: ((PageAccount) r).getAdmins()) {
	    			admins.add(u);
	    		}
			}
    	
    	}
    	Set<Sommet> items = new HashSet<Sommet>();
    	for (Sommet e: admins) {
            items.add(e);
        }
    	return items;

    }
    
    // nombre de degree sortant, nb de l'ensemble des voisins sortants de s:
    public static int nb_sortant(Sommet s) {
    	
		return relations.get(s).size();
    }
    // nombre de degree entrant, nb de l'ensemble des voisins entrant de s:
    public int nb_entrant(Sommet s) {
    	return li_entrant(s).size();
    	
    }
    
	// list des voisin entrants de s:
    public static List<Sommet> li_entrant(Sommet s){
    	List<Sommet> v = new ArrayList<Sommet>();
		for(Sommet sm : relations.keySet()) {
			if(relations.get(sm).contains(s)) {
				v.add(sm);
			}
		}	
    	return v;
    	
    }

    public static int PageRank(Sommet s) {
	   int somme = 0;
	   int pr = 1;
	   for(Sommet r: li_entrant(s)) {
		   somme += PageRank(r) / nb_sortant(r);
	   }
	   pr = (int) ((0.15 / Nb_Sommet()) +(0.85 * somme));
			   return pr;	
    }
    
    public static HashMap<Sommet, Integer> rank() {
    	HashMap<Sommet, Integer> k = new HashMap<Sommet,Integer>();
    	for(Sommet s: listSommet) {
    		k.put(s, 1);
    	}
    	int i = 0;
    	while( i <= 100) {
    		for(Sommet s: listSommet) {
        		k.put(s, PageRank(s));
        	}
    		i++;
    	}
		return k;
    	
    }
    
    public static void graphe_to_file() {
    	
    	try {
    	      FileWriter myWriter = new FileWriter("ListAdjacence.txt");
    	      
				for (Sommet s : Graphe.relations.keySet()) {
					String abs = s.getNom() + " -> [ " ;
					for (Sommet v : Graphe.relations.get(s)) {
						abs +=  v.getNom() + " , ";
					}
					myWriter.write(abs + " ] \n");
    	  	}
    	  			
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
		
    	
    }
 
  
}
