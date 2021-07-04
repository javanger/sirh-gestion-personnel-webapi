/**
 * 
 */
package com.sirh.personnel.webapi.entity;

/**
 * @author Kevin M.
 *
 */
public class Cordonnees {

	/* phone : String */
	private String phone;
	/** adresse : String */
	private String adresse;

	/** Constructor
	 * 
	 */
	public Cordonnees() {
		phone = "";
		adresse = "";
	}

	/**
	 * Constructor
	 * 
	 * @param phone
	 * @param adresse
	 */
	public Cordonnees(String phone, String adresse) {
		super();
		this.phone = phone;
		this.adresse = adresse;
	}

	/**
	 * Getter
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter
	 * 
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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

}
