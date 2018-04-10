/**
 * 
 */
package dev.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestion.entite.Collaborateur;
import dev.gestion.repository.CollaborateurRepository;

/**
 * @author Axel B.
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurR;

	@GetMapping
	public List<Collaborateur> listerCollaborateur1() {
		return this.collaborateurR.findAll();

	}

	@RequestMapping(params = { "departement" })
	public List<Collaborateur> findByDepartement(@RequestParam("departement") Integer id) {
		return collaborateurR.findByDepartement(id);
	}

	@RequestMapping(value = "/{matricule}")
	public Collaborateur find(@PathVariable String matricule) {
		return collaborateurR.findByMatricule(matricule);
	}

}
