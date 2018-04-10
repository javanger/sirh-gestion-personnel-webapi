/**
 * 
 */
package dev.sgp.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "NOM")
	String nom;
	@Column(name = "IBAN")
	String IBAN;
	@Column(name = "BIC")
	String BIC;

	public Banque() {
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
	 * @return the iBAN
	 */
	public String getIBAN() {
		return IBAN;
	}

	/**
	 * Setter
	 * 
	 * @param iBAN
	 *            the iBAN to set
	 */
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	/**
	 * Getter
	 * 
	 * @return the bIC
	 */
	public String getBIC() {
		return BIC;
	}

	/**
	 * Setter
	 * 
	 * @param bIC
	 *            the bIC to set
	 */
	public void setBIC(String bIC) {
		BIC = bIC;
	}

}
