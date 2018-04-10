package dev.sgp.entite;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Emmanuel
 *
 */
@Entity
@Table(name = "COLLABORATEUR")
public class Collaborateur {

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	/** matricule : String */
	@Column(name = "MATRICULE", length = 20)
	private String matricule;

	/** nom : String */
	@Column(name = "NOM", length = 20)
	private String nom;

	/** nom : String */
	@Column(name = "PRENOM", length = 20)
	private String prenom;

	/** dateDeNaissance : LocalDate */
	@Column(name = "DATE_DE_NAISSANCE")
	private LocalDate dateDeNaissance;

	/** adresse : String */
	@Column(name = "ADRESSE", length = 75)
	private String adresse;

	/** departement : Departement */
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTEMENT")
	private Departement departement;
	
	@Embedded
	private Banque banque;

	/** dateheureCreation : ZonedDateTime */
	@Column(name = "DATECREATION")
	private LocalDateTime dateHeureCreation;

	public Collaborateur() {
		// Constructeur vide
	}

	public Collaborateur(String unNom, String unPrenom, String uneDateDeNaissance, String uneAdresse, Departement departement, Banque banque) {

		Random rnd = new Random();
		this.matricule = 100000 + rnd.nextInt(900000) + "";
		this.nom = unNom;
		this.prenom = unPrenom;
		this.dateDeNaissance = LocalDate.parse(uneDateDeNaissance);
		this.adresse = uneAdresse;
		this.dateHeureCreation = LocalDateTime.now();
		this.departement = departement;
		this.banque = banque;
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Getter
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Getter
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Getter
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Setter
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Setter
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Setter
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
}
