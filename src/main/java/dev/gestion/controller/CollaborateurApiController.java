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
 * @author Alexis Darcy
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@GetMapping
	public List<Collaborateur> listerCollaborateur() {
		return this.collaborateurRepository.findAll();
	}

	@GetMapping(params = { "departement" })
	public List<Collaborateur> listerCollaborateurByDepartement(@RequestParam("departement") Integer id) {
		return this.collaborateurRepository.findByDepartementId(id);
	}

	@GetMapping(path = { "/{matricule}" })
	public Collaborateur afficherCollaborateur(@PathVariable("matricule") String matricule) {
		return this.collaborateurRepository.findByMatricule(matricule);
	}

}

