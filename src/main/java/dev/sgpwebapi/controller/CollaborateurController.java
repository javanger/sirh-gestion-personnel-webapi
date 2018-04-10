package dev.sgpwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Banque;
import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateurController {
	@Autowired
	private CollaborateurRepository collarepo;

	@GetMapping(params = "departement")
	List<Collaborateur> getIdByValue(@RequestParam Integer departement) {

		return this.collarepo.findByDepartementId(departement);
	}

	@GetMapping
	public List<Collaborateur> listerCollaborateur() {
		return this.collarepo.findAll();

	}

	@GetMapping(value = "/{matricule}")
	Collaborateur getCollaborateurByMatricule(@PathVariable("matricule") String matricule) {

		return collarepo.findByMatricule(matricule);
	}

	@PutMapping(value = "/{matricule}")
	public void updateCollaborateur(@PathVariable("matricule") String matricule,
			@RequestBody Collaborateur collaborateur) {
		Collaborateur mdCollaborateur = collarepo.findByMatricule(matricule);
		mdCollaborateur.setAdresse(collaborateur.getAdresse());
		mdCollaborateur.setNom(collaborateur.getNom());
		mdCollaborateur.setPrenom(collaborateur.getPrenom());

		collarepo.save(mdCollaborateur);

	}

	@GetMapping(value = "/{matricule}/banque")
	Banque getCollaborateurBanqueByMatricule(@PathVariable("matricule") String matricule) {

		return collarepo.findByMatricule(matricule).getBanque();
	}

	@PutMapping(value = "/{matricule}/banque")
	public void updateBanqueCollaborateur(@PathVariable("matricule") String matricule, @RequestBody Banque banque) {
		Collaborateur mdCollaborateur = collarepo.findByMatricule(matricule);
		mdCollaborateur.setBanque(banque);

		collarepo.save(mdCollaborateur);

	}



}
