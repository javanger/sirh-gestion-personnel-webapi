/**
 * 
 */
package dev.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestion.entite.Banque;
import dev.gestion.entite.Collaborateur;
import dev.gestion.repository.BanqueRepository;
import dev.gestion.repository.CollaborateurRepository;
import dev.gestion.repository.DepartementRepository;

/**
 * @author Alexis Darcy
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private BanqueRepository banqueRepository;
	@Autowired
	private DepartementRepository departementRepository;

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

	@PutMapping(path = { "/{matricule}" })
	public void modifierCollaborateur(@PathVariable("matricule") String matricule,
			@RequestBody Collaborateur collaborateur) {
		if (collaborateurRepository.existsByMatricule(matricule)) {
			if (banqueRepository.existsById(collaborateur.getBanque().getId())
					&& departementRepository.existsById(collaborateur.getDepartement().getId())) {
				this.collaborateurRepository.save(collaborateur);
				this.banqueRepository.save(collaborateur.getBanque());
				this.departementRepository.save(collaborateur.getDepartement());
			}
		}
	}

	@GetMapping(path = { "/{matricule}/banque" })
	public Banque afficherBanque(@PathVariable("matricule") String matricule) {
		if (collaborateurRepository.existsByMatricule(matricule)) {
			Collaborateur collaborateur = this.collaborateurRepository.findByMatricule(matricule);
			Optional<Banque> banque = this.banqueRepository.findById(collaborateur.getBanque().getId());
			if (banque.isPresent()) {
				return banque.get();
			}
		}
		return null;
	}

	@PutMapping(path = { "/{matricule}/banque" })
	public void modifierBanque(@PathVariable("matricule") String matricule, @RequestBody Banque banque) {
		if (collaborateurRepository.existsByMatricule(matricule)) {
			if (banqueRepository.existsById(banque.getId())) {
				Collaborateur collaborateur = this.collaborateurRepository.findByMatricule(matricule);
				collaborateur.getBanque().setLibelle(banque.getLibelle());
				collaborateur.getBanque().setBic(banque.getBic());
				collaborateur.getBanque().setIban(banque.getIban());
				this.banqueRepository.save(collaborateur.getBanque());
			}
		}
	}
}

