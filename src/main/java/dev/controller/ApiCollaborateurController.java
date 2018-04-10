package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Banque;
import dev.entite.Collaborateurs;
import dev.repository.BanqueRepository;
import dev.repository.CollaborateursRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class ApiCollaborateurController {

	@Autowired
	private CollaborateursRepository collaborateurRepo;

	@Autowired
	private BanqueRepository banqueRepo;

	@GetMapping
	public List<Collaborateurs> listercollaborateurs() {
		return this.collaborateurRepo.findAll();
	}

	@GetMapping(params = "departement")
	List<Collaborateurs> getIdByValue(@RequestParam Integer departement) {

		return this.collaborateurRepo.findByDepartementId(departement);
	}

	@GetMapping(value = "/{matricule}")
	Collaborateurs getCollaborateurByMatricule(@PathVariable("matricule") String matricule) {

		return collaborateurRepo.findByMatricule(matricule);
	}

	@PutMapping("/{matricule}")
	public void collab(@PathVariable("matricule") String matricule, @RequestBody Collaborateurs collab)
	{
		Collaborateurs collabo = collaborateurRepo.findByMatricule(matricule);
		collabo.setId(collabo.getId());
		collabo.setNom(collabo.getNom());
		collabo.setDepartement(collabo.getDepartement());
		collaborateurRepo.save(collabo);
	}

	@GetMapping(value = "/{matricule}/banque")
	Banque getCollaborateurByBanque(@PathVariable("matricule") String matricule) {

		Collaborateurs collabo = collaborateurRepo.findByMatricule(matricule);
		Banque banqueCollaborateur = collabo.getBanque();
		return banqueCollaborateur;

	}

	@PutMapping("/{matricule}/banque")
	public void collab(@PathVariable("matricule") String matricule, @RequestBody Banque banque) {
		Collaborateurs collabo = collaborateurRepo.findByMatricule(matricule);
		Banque newBanque = collabo.getBanque();
		newBanque.setId(newBanque.getId());
		newBanque.setCoordonneeBancaire(newBanque.getCoordonneeBancaire());
		newBanque.setNom(newBanque.getNom());

		collabo.setBanque(newBanque);
		collaborateurRepo.save(collabo);
	}


}
