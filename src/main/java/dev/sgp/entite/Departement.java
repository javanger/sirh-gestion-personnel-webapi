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
	private Integer id;
	
	/** nom : String */
	@Column(name = "NOM", length = 30)
	private String nom;
	
	public Departement() {
		// Constructeur vide
	}

	public Departement(String nom) {
		this.nom = nom;
	}
	
	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
