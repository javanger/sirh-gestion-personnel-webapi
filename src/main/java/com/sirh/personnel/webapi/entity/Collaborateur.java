/**
 * 
 */
package com.sirh.personnel.webapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Kevin M.
 *
 */
@Entity
public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** matricule : String */
	private String matricule;

	@Embedded
	private Identite identite;

	@Embedded
	private Cordonnees cordonnees;

	/** emailProfessionnel : String */
	private String emailProfessionnel;
	/** dateHeureCreation : LocalDateTime */
	private LocalDateTime dateHeureCreation;
	/** estActif : Boolean */
	private Boolean estActif;
	/** intitulePoste : String */
	private String intitulePoste;
	/** departement : Departement */

	@ManyToOne
	private Departement departement;

	@Embedded
	private Banque banque;

	/**
	 * Constructor
	 * 
	 */
	public Collaborateur() {
		matricule = "";
		emailProfessionnel = "";
		intitulePoste = "";
	}


	/** Constructor
	 * @param matricule
	 * @param identite
	 * @param adresse
	 * @param estActif
	 * @param intitulePoste
	 * @param departement
	 * @param banque
	 */
	public Collaborateur(String matricule, String intitulePoste, Boolean estActif, Identite identite,
			Cordonnees cordonnees,
			Departement departement, Banque banque) {
		super();
		this.matricule = matricule;
		this.estActif = estActif;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
		this.identite = identite;
		this.banque = banque;
		this.cordonnees = cordonnees;
		this.emailProfessionnel = String.format("%s.%s@domain.com", identite.getPrenom(), identite.getNom());
		this.dateHeureCreation = LocalDateTime.now();
	}

	/**
	 * Getter
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	/**
	 * Getter
	 * 
	 * @return the emailProfessionnel
	 */
	public String getEmailProfessionnel() {
		return emailProfessionnel;
	}

	/**
	 * Setter
	 * 
	 * @param emailProfessionnel
	 *            the emailProfessionnel to set
	 */
	public void setEmailProfessionnel(String emailProfessionnel) {
		this.emailProfessionnel = emailProfessionnel;
	}

	/**
	 * Getter
	 * 
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * Setter
	 * 
	 * @param dateHeureCreation
	 *            the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * Getter
	 * 
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}

	/**
	 * Setter
	 * 
	 * @param estActif
	 *            the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	/**
	 * Getter
	 * 
	 * @return the intitulePoste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}

	/**
	 * Setter
	 * 
	 * @param intitulePoste
	 *            the intitulePoste to set
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	/**
	 * Getter
	 * 
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * Setter
	 * 
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Setter
	 * 
	 * @param banque
	 *            the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * Getter
	 * 
	 * @return the identite
	 */
	public Identite getIdentite() {
		return identite;
	}

	/**
	 * Setter
	 * 
	 * @param identite
	 *            the identite to set
	 */
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	/**
	 * Getter
	 * 
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * Getter
	 * 
	 * @return the cordonnees
	 */
	public Cordonnees getCordonnees() {
		return cordonnees;
	}

	/**
	 * Setter
	 * 
	 * @param cordonnees
	 *            the cordonnees to set
	 */
	public void setCordonnees(Cordonnees cordonnees) {
		this.cordonnees = cordonnees;
	}

}
