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
 * @author Alexis Darcy
 *
 */
@RestController
@RequestMapping("/api/departements")
public class DepartementApiController {

	@Autowired
	private DepartementRepository departementRepository;

	@GetMapping
	public List<Departement> listerDepartement() {
		return this.departementRepository.findAll();
	}
}

