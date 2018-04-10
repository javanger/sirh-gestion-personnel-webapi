/**
 * 
 */
package com.sirh.personnel.webapi.entity;

import java.time.LocalDate;

import javax.persistence.Embeddable;

/**
 * @author Kevin M.
 *
 */
@Embeddable
public class Identite {

	/** nom : String */
	private String nom;
	/** prenom : String */
	private String prenom;
	/** photo : String */
	private String photo;
	/** dateNaissance : LocalDate */
	private LocalDate dateNaissance;
	/** numeroSecuriteSociale : String */
	private String numeroSecuriteSociale;
	/**
	 * Constructor
	 * 
	 */
	public Identite() {
		nom = "";
		prenom = "";
		photo = "";
		numeroSecuriteSociale = "";
	}

	/**
	 * Constructor
	 * 
	 * @param nom
	 * @param prenom
	 * @param photo
	 * @param dateNaissance
	 */
	public Identite(String nom, String prenom, String photo, LocalDate dateNaissance, String numeroSecuriteSociale) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.numeroSecuriteSociale = numeroSecuriteSociale;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * 
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Setter
	 * 
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Getter
	 * 
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter
	 * 
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter
	 * 
	 * @return the numeroSecuriteSociale
	 */
	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}

	/**
	 * Setter
	 * 
	 * @param numeroSecuriteSociale
	 *            the numeroSecuriteSociale to set
	 */
	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
	}

}
