package classes;

public class UserAccount extends Sommet  {
	
	private int Age;
	

	public UserAccount( String Nom, int Age) {
		super( Nom);
	    this.Age = Math.max(1, Age);
	}

	
	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	
	
	public String infos() {
		return "le nom de profile : " + Nom +
				"\n L'age du proprietaire est : " + Age + 
				"\n il a  : " + Graphe.relations.get(this).size() + " amis";
	}


	
}
