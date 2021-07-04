/**
 * 
 */
package com.sirh.personnel.webapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Kevin M.
 *
 */
@Entity
public class Departement {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** name : String */
	private String name;

	/**
	 * Constructor
	 * 
	 */
	public Departement() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param name
	 */
	public Departement(Integer id, String name) {
		this.id = id;
		this.name = name;
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
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
