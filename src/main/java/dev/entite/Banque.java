package dev.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "COORDONNEES_BANCAIRE")
	private String coordonneeBancaire;
	@Column(name = "NOM")
	private String nom;

	public Banque() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the coordonneeBancaire
	 */
	public String getCoordonneeBancaire() {
		return coordonneeBancaire;
	}

	/**
	 * @param coordonneeBancaire
	 *            the coordonneeBancaire to set
	 */
	public void setCoordonneeBancaire(String coordonneeBancaire) {
		this.coordonneeBancaire = coordonneeBancaire;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
