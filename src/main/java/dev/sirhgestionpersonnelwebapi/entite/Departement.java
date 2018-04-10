package dev.sirhgestionpersonnelwebapi.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departement")
public class Departement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;


	@Column(name = "NOM_DEPARTEMENT", length = 20, nullable = true)
	private String nomDepartement;
	
	public Departement() {

	}
	
	public Departement(String nomDepartement) {
		
		
		this.nomDepartement = nomDepartement;
	}



	



	public String getNomDepartement() {
		return nomDepartement;
	}



	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}







	
	
	
	

}
