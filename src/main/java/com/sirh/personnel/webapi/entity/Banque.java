/**
 * 
 */
package com.sirh.personnel.webapi.entity;

import javax.persistence.Embeddable;

/**
 * @author Kevin M.
 *
 */
@Embeddable
public class Banque {

	/* banque : String */
	private String denomination;
	/* bic : String */
	private String bic;
	/* iban : String */
	private String iban;

	/**
	 * Constructor
	 * 
	 */
	public Banque() {
		this.denomination = "";
		this.bic = "";
		this.iban = "";
	}

	/**
	 * Constructor
	 * 
	 * @param denomination
	 * @param bic
	 * @param iban
	 */
	public Banque(String denomination, String bic, String iban) {
		super();
		this.denomination = denomination;
		this.bic = bic;
		this.iban = iban;
	}

	/**
	 * Getter
	 * 
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * Setter
	 * 
	 * @param denomination
	 *            the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
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
