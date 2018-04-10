package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.BanqueRepository;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementsRepository;

@RestController
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;
	@Autowired
	private BanqueRepository banqueRepo;
	@Autowired
	private DepartementsRepository departementRepo;

	@RequestMapping(value = "/collaborateur", method = RequestMethod.GET)
	public List<Collaborateur> listerexemples() {
		return this.collaborateurRepo.findAll();
	}

	@RequestMapping(value = "/collaborateur", method = RequestMethod.GET, params = { "departement" })
	public List<Collaborateur> findCollabByDepartement(@RequestParam("departement") Integer id) {
		return collaborateurRepo.findByDepartementId(id);
	}

	@RequestMapping(value = "/collaborateur/{matricule}", method = RequestMethod.GET)
	public Collaborateur findCollab(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule);
	}

	@RequestMapping(value = "/collaborateur/{matricule}/banque", method = RequestMethod.GET)
	public Banque findBanque(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule).getBanque();
	}

	@RequestMapping(value = "/collaborateur/{matricule}", method = RequestMethod.PUT)
	public void changeCollab(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		Collaborateur collaborateur = collaborateurRepo.findByMatricule(collab.getMatricule());
		collaborateur.setDepartement(departementRepo.getOne(collab.getDepartement().getId()));
		collaborateur.setBanque(banqueRepo.getOne(collab.getBanque().getId()));
		collaborateurRepo.save(collaborateur);
	}

	@RequestMapping(value = "/collaborateur/{matricule}/banque", method = RequestMethod.PUT)
	public void changeBanque(@PathVariable String matricule, @RequestBody Banque banqueModif) {
		Banque banque = collaborateurRepo.findByMatricule(matricule).getBanque();
		banque.setBic(banqueModif.getBic());
		banque.setIban(banqueModif.getIban());
		banque.setNom(banqueModif.getNom());
		banqueRepo.save(banque);
		collaborateurRepo.findByMatricule(matricule).setBanque(banque);
		
		collaborateurRepo.save(collaborateurRepo.findByMatricule(matricule));
	}
}
