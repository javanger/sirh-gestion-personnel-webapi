package dev.sirhgestionpersonnelwebapi.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Collaborateur")
public class Collaborateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "MATRICULE", length = 40, nullable = true)
	private String matricule;

	@Column(name = "NOM", length = 40, nullable = true)
	private String nom;

	@Column(name = "PRENOM", length = 40, nullable = true)
	private String prenom;

	@Column(name = "DATE_DE_NAISSANCE", length = 40, nullable = true)
	private LocalDate dateDeNaissance ;

	@Column(name = "ADRESSE", length = 40, nullable = true)
	private String adresse; 

	@Column(name = "NUM_SECU_SOCIAL", length = 40, nullable = true)
	private String numDeSecuSocial;

	@Column(name = "EMAIL", length = 40, nullable = true)
	private String emailPro;

	@Column(name = "PHOTO", length = 40, nullable = true)
	private String photo;

	@Column(name = "DATE_HEURE_CREATION", length = 40, nullable = true)
	private ZonedDateTime dateHeureCreation;

	@Column(name = "ACTIF")
	private boolean actif;


	@Column(name = "INTITULE_POSTE", length = 40, nullable = true)
	private String intitulePoste;

	@ManyToOne
	private Departement departement ;
	
	
	
	
	public Collaborateur() {
		super();
		
		
		
	}

	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse,
			String numDeSecuSocial, String emailPro, String photo, ZonedDateTime dateHeureCreation, boolean actif,
			String intitulePoste, Departement departement) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numDeSecuSocial = numDeSecuSocial;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNumDeSecuSocial() {
		return numDeSecuSocial;
	}


	public void setNumDeSecuSocial(String numDeSecuSocial) {
		this.numDeSecuSocial = numDeSecuSocial;
	}


	public String getEmailPro() {
		return emailPro;
	}


	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}


	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}


	public boolean isActif() {
		return actif;
	}


	public void setActif(boolean actif) {
		this.actif = actif;
	}


	@Override
	public String toString() {
		return "Collaborateur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance="
				+ dateDeNaissance + ", adresse=" + adresse + ", numDeSecuSocial=" + numDeSecuSocial + ", emailPro="
				+ emailPro + ", photo=" + photo + ", dateHeureCreation=" + dateHeureCreation + ", actif=" + actif + "]";
	}







	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public String getIntitulePoste() {
		return intitulePoste;
	}


	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}


	
	
	
	
	

}
