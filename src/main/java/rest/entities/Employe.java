package rest.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employe {
	
	private int cin;
	private String nom;
	private String prenom;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(int cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//@XmlElement(name="FirstName")
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cin;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (cin != other.cin)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	

}
