package dev.sirhgestionpersonnelwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sirhgestionpersonnelwebapi.entite.Collaborateur;
import dev.sirhgestionpersonnelwebapi.repository.CollaborateurRepository;
import dev.sirhgestionpersonnelwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {
	@Autowired
	private CollaborateurRepository collaborateurRepo;
	@Autowired
	private DepartementRepository departementRepo;



	@GetMapping
	public List<Collaborateur> listerCollaborateur() {

		return this.collaborateurRepo.findAll();

	}

	@GetMapping(params = "departement")
	public List<Collaborateur> findByIdDepartement(@RequestParam Integer departement) {
		return collaborateurRepo.findByDepartementId(departement);


	}

	@GetMapping("/{matricule}")
	public Collaborateur findMatricule(@PathVariable String matricule) {
		return this.collaborateurRepo.findByMatricule(matricule);

	}

	@PutMapping("/{matricule}")
	public void modifyMatricule(@PathVariable String matricule, @RequestBody Collaborateur collab) {

		// collaborateurRepo.findByMatricule(matricule);
		// collab.setMatricule(matricule);
		Collaborateur collaborateur = collaborateurRepo.findByMatricule(matricule);
		// collaborateur.setDepartement(departementRepo.getOne(collab.getDepartement().getId()));
		// collaborateur.setBanque(banqueRepo.getOne(collab.getBanque().getId()));

		collab.setId(collaborateur.getId());
		collaborateurRepo.save(collab);




	}

}
