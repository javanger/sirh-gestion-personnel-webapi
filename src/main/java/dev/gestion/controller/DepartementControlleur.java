/**
 * 
 */
package dev.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestion.entite.Departement;
import dev.gestion.repository.DepartementRepository;

/**
 * @author Axel B.
 *
 */
@RestController
@RequestMapping("/api/departements")
public class DepartementControlleur {

	@Autowired
	private DepartementRepository departementR;

	@GetMapping
	public List<Departement> listerDepartements() {
		return this.departementR.findAll();
	}

}
