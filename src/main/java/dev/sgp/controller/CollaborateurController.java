/**
 * 
 */
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
import dev.sgp.repository.DepartementRepository;

/**
 * @author GOBERT Guillaume
 *
 *
 */
@RestController
public class CollaborateurController {

	@Autowired
	CollaborateurRepository collaborateurRepo;
	@Autowired
	BanqueRepository banqueRepo;
	@Autowired
	DepartementRepository departementRepo;

	@RequestMapping("/collaborateurs")
	public List<Collaborateur> ListeCollaborateurs() {
		return this.collaborateurRepo.findAll();
	}

	@RequestMapping(value = "/collaborateurs", method = RequestMethod.GET, params = {
			"idDepartement" })
	public List<Collaborateur> CollaborateursParDepartement(@RequestParam("idDepartement") Integer idDepartement) {
		return this.collaborateurRepo.findCollaborateursByDepartement(idDepartement);
	}

	@RequestMapping(value = "/collaborateurs/{matricule}", method = RequestMethod.GET)
	public Collaborateur RecupCollaborateur(@PathVariable String matricule) {
		return this.collaborateurRepo.findCollaborateurByMatricule(matricule);
	}

	@RequestMapping(value = "/collaborateurs/{matricule}", method = RequestMethod.PUT)
	public void ModifierCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		Collaborateur collaborateur = new Collaborateur();
		if (collaborateurRepo.existsByMatricule(matricule)) {
			collaborateur = collaborateurRepo.findCollaborateurByMatricule(collab.getMatricule());
			if (banqueRepo.existsById(collab.getBanque().getId())
					&& departementRepo.existsById(collab.getDepartement().getId()))
				collaborateur.setDepartement(departementRepo.getOne(collab.getDepartement().getId()));
			collaborateur.setBanque(banqueRepo.getOne(collab.getBanque().getId()));

			collaborateurRepo.save(collaborateur);
		}
	}

	@RequestMapping(value = "/collaborateurs/{matricule}/banque", method = RequestMethod.GET)
	public Banque BanqueParCollaborateur(@PathVariable String matricule) {
		Collaborateur collab = collaborateurRepo.findCollaborateurByMatricule(matricule);
		Banque banqueCollaborateur = collab.getBanque();
		return banqueCollaborateur;
	}

	@RequestMapping(value = "/collaborateurs/{matricule}/banque", method = RequestMethod.PUT)
	public void ModifierBanqueParUtilisatuer(@PathVariable String matricule, @RequestBody Banque banque) {
		Collaborateur collab = collaborateurRepo.findCollaborateurByMatricule(matricule);

		Banque banqueNouvelle = collab.getBanque();
		banqueNouvelle.setNom(banque.getNom());
		banqueNouvelle.setBIC(banque.getBIC());
		banqueNouvelle.setIBAN(banque.getIBAN());
		banqueRepo.save(banqueNouvelle);

		collab.setBanque(banqueNouvelle);
		collaborateurRepo.save(collab);
	}
}
