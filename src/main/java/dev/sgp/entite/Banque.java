package dev.sgp.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Emmanuel
 *
 */
@Embeddable
public class Banque {
	
	/** nom : String */
	@Column(name = "LIBELLE", length = 30)
	private String libelle;
	
	/** idban : String */
	@Column(name = "IBAN", length = 50)
	private String iban;
	
	/** bic : String */
	@Column(name = "BIC", length = 50)
	private String bic;
	
	public Banque() {
		// Constructeur vide
	}

	public Banque(String libelle, String iban, String bic) {
		this.libelle = libelle;
		this.iban = iban;
		this.bic = bic;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return libelle;
	}

	/** Getter
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/** Getter
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.libelle = nom;
	}
	

	/** Setter
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/** Setter
	 * @param bic the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}
	
}
