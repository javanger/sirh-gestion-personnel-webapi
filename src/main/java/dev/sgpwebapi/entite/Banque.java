package dev.sgpwebapi.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Banque {
	@Column(name = "BANQUE")
	private String banque;

	@Column(name = "BIC")
	private String bic;

	@Column(name = "IBAN")
	private String iban;

	public Banque() {

		// TODO Auto-generated constructor stub
	}

	public Banque(String banque, String bic, String iban) {
		super();
		this.banque = banque;
		this.bic = bic;
		this.iban = iban;
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
