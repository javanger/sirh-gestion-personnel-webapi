package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;

/**
 * @author Emmanuel
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {

		return this.collaborateurRepository.findAll();

	}

	@GetMapping(params = "departement")
	public List<Collaborateur> listerCollaborateurs(@RequestParam(value = "departement") Integer idDepartement) {

		return this.collaborateurRepository
				.findByDepartementId(idDepartement);

	}

}
