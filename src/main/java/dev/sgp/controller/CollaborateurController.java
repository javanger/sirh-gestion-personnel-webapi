package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementRepository;

/**
 * @author Emmanuel
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	
	@Autowired
	private DepartementRepository departementRepository;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {

		return this.collaborateurRepository.findAll();

	}

	@GetMapping("departement")
	public List<Collaborateur> listerCollaborateurs(@RequestParam(value = "departement") Integer idDepartement) {

		return this.collaborateurRepository.findByDepartementId(idDepartement);

	}

	@GetMapping("/{matricule}")
	public Collaborateur getCollaborateur(@PathVariable(value = "matricule") String matricule) {

		return this.collaborateurRepository.findByMatricule(matricule);

	}
	
	@PutMapping("/{matricule}")
	public void updateCollaborateur(
			@PathVariable(value = "matricule") String matricule, 
			@RequestBody Collaborateur collaborateur) {

			Collaborateur collaborateurModifie = this.collaborateurRepository.findByMatricule(matricule);
			
			collaborateurModifie.setNom(collaborateur.getNom());
			collaborateurModifie.setPrenom(collaborateur.getPrenom());
			collaborateurModifie.setDepartement(collaborateur.getDepartement());
			
			collaborateurRepository.save(collaborateurModifie);

	}

}
