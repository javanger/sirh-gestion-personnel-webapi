/**
 * 
 */
package dev.gestion.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Axel B.
 *
 */
@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "LIBELLE")
	private String libelle;

	@Column(name = "IBAN")
	private String iban;

	@Column(name = "BIC")
	private String bic;

	public Banque() {

	}

	public Banque(String libelle, String iban, String bic) {
		this.libelle = libelle;
		this.iban = iban;
		this.bic = bic;
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
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban
	 *            the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * @param bic
	 *            the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", iban=" + iban + ", bic=" + bic + "]";
	}

}
