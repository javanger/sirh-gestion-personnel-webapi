/**
 * 
 */
package dev.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestion.entite.Banque;
import dev.gestion.entite.Collaborateur;
import dev.gestion.repository.BanqueRepository;
import dev.gestion.repository.CollaborateurRepository;
import dev.gestion.repository.DepartementRepository;

/**
 * @author Axel B.
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurR;

	@Autowired
	private DepartementRepository departementR;

	@Autowired
	private BanqueRepository banqueR;

	@GetMapping
	public List<Collaborateur> listerCollaborateur1() {
		return this.collaborateurR.findAll();

	}

	@RequestMapping(params = { "departement" })
	public List<Collaborateur> findByDepartement(@RequestParam("departement") Integer id) {
		return collaborateurR.findByDepartement(id);
	}

	@RequestMapping(value = "/{matricule}", method = RequestMethod.GET)
	public Collaborateur find(@PathVariable String matricule) {
		return collaborateurR.findByMatricule(matricule);
	}

	@RequestMapping(value = "/{matricule}", method = RequestMethod.PUT)
	public void ModifierCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		if (collaborateurR.existsByMatricule(matricule)) {
			if (banqueR.existsById(collab.getBanque().getId())
					&& departementR.existsById(collab.getDepartement().getId()))
				collaborateurR.save(collab);

		}

	}

	@RequestMapping(value = "/{matricule}/banque", method = RequestMethod.GET)
	public Banque BanqueCollab(@PathVariable String matricule) {
		Collaborateur collab = collaborateurR.findByMatricule(matricule);

		Banque banqueCollaborateur = collab.getBanque();
		return banqueCollaborateur;
	}

	@RequestMapping(value = "/{matricule}/banque", method = RequestMethod.PUT)
	public void updateBanqueCollaborateur(@PathVariable("matricule") String matricule, @RequestBody Banque banque) {
		Collaborateur mdCollaborateur = collaborateurR.findByMatricule(matricule);
		mdCollaborateur.setBanque(banque);

		collaborateurR.save(mdCollaborateur);

	}

}
