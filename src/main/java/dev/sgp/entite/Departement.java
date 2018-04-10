package dev.sgp.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel
 *
 */
@Entity
@Table(name = "DEPARTEMENT")
public class Departement {
	
	// INSERT INTO DEPARTEMENT(NOM) VALUES ('GIRONDE')

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	/** nom : String */
	@Column(name = "NOM", length = 30)
	private String nom;
	
	public Departement() {
		// Constructeur vide
	}
	
	public Departement(String unNom) {
		this.nom = unNom;
	}
	
	@Override
	public String toString() {
		return nom;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
