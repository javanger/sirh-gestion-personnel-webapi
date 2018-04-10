package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;

@RestController
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;

	@RequestMapping(value = "/collaborateur", method = RequestMethod.GET)
	public List<Collaborateur> listerexemples() {
		return this.collaborateurRepo.findAll();
	}

	@RequestMapping(value = "/collaborateur", method = RequestMethod.GET, params = { "departement" })
	public List<Collaborateur> findCollabByDepartement(@RequestParam("departement") Integer id) {
		return collaborateurRepo.findCollabByDepartement(id);
	}

	@RequestMapping(value = "/collaborateur/{matricule}", method = RequestMethod.GET)
	public Collaborateur findCollab(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule);
	}
}
