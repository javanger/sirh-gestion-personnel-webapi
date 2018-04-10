package dev.sgpwebapi.entite;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLLABORATEURS")

public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "MATRICULE")
	String matricule;

	@Column(name = "NOM")
	String nom;

	@Column(name = "PRENOM")
	String prenom;

	@Column(name = "DATE_DE_NAISSANCE")
	LocalDate dateDeNaissance;

	@Column(name = "ADRESSE")
	String adresse;

	@Column(name = "DATE_HEURE_CREATION")
	LocalDateTime dateHeureCreation;

	@Column(name = "INTITULE_POSTE")
	String intitulePoste;

	@ManyToOne
	@JoinColumn(name = "ID_DEPARTEMENT")
	Departement departement;

	@Column(name = "BANQUE")
	String banque;

	@Column(name = "BIC")
	String bic;

	@Column(name = "IBAN")
	String iban;

	public Collaborateur() {

		// TODO Auto-generated constructor stub
	}

	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse,
			String intitulePoste, Departement departement) {

		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.dateHeureCreation = LocalDateTime.now();
		this.intitulePoste = intitulePoste;
		this.departement = departement;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * Setter
	 * 
	 * @param dateDeNaissance
	 *            the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * Getter
	 * 
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 * 
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	 * @return the banque
	 */
	public String getBanque() {
		return banque;
	}

	/**
	 * Setter
	 * 
	 * @param banque
	 *            the banque to set
	 */
	public void setBanque(String banque) {
		this.banque = banque;
	}

	/**
	 * Getter
	 * 
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * Setter
	 * 
	 * @param bic
	 *            the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

	/**
	 * Getter
	 * 
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * Setter
	 * 
	 * @param iban
	 *            the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

}
