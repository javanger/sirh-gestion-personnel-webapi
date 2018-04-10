/**
 * 
 */
package com.sirh.personnel.webapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sirh.personnel.webapi.entity.Banque;
import com.sirh.personnel.webapi.entity.Collaborateur;
import com.sirh.personnel.webapi.entity.Departement;
import com.sirh.personnel.webapi.repository.CollaborateurRepository;
import com.sirh.personnel.webapi.repository.DepartementRepository;

/**
 * @author Kevin M.
 *
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	CollaborateurRepository cRepo;

	@Autowired
	DepartementRepository dRepo;

	@GetMapping
	public List<Collaborateur> searchAll() {
		return cRepo.findAll();
	}

	@GetMapping(params = "departement")
	public List<Collaborateur> searchById(@RequestParam Integer departement) {
		Optional<Departement> departementOpt = dRepo.findById(departement);
		if (departementOpt.isPresent()) {
			return cRepo.findByDepartement(departementOpt.get());
		}
		return new ArrayList<>();
	}

	@GetMapping(value = "/{matricule}")
	public Collaborateur searchByMatricule(@PathVariable String matricule) {
		Optional<Collaborateur> collaborateur = cRepo.findByMatricule(matricule);
		return collaborateur.isPresent() ? collaborateur.get() : null;
	}

	@PutMapping(value = "/{matricule}")
	public @ResponseBody Collaborateur updateByMatricule(@PathVariable String matricule,
			@RequestBody Collaborateur collaborateur, HttpServletResponse response) throws IOException {

		// Récupérer le collaborateur par son matricule
		Optional<Collaborateur> collaborateurOpt = cRepo.findByMatricule(matricule);
		Collaborateur newCollaborateur = null;
		if (collaborateurOpt.isPresent()) {
			Integer id = collaborateurOpt.get().getId();
			collaborateur.setId(id);
			// TODO Validation avant de persister
			newCollaborateur = cRepo.save(collaborateur);

			if (null == newCollaborateur) {
				response.sendError(400, "Erreur lors de la mofication d'un collaboratuer: " + matricule);
			} else {
				response.setHeader("message", "Collaborateur modifié avec succès");
				response.setStatus(200);
			}
		}
		return newCollaborateur;
	}

	// GET /api/collaborateurs/[MATRICULE]/banque : récupère les coordonnées
	// bancaires d’un collaborateur
	@GetMapping(value = "/{matricule}/banque")
	public Banque sendBanqueByMatricule(@PathVariable String matricule) {
		Optional<Collaborateur> collaborateur = cRepo.findByMatricule(matricule);
		if (collaborateur.isPresent()) {
			return collaborateur.get().getBanque();
		}
		return null;
	}

	// PUT /api/collaborateurs/[MATRICULE]/banque : modifie uniquement les
	// coordonnées bancaires d’un collaborateur.
	@PutMapping(value = "/{matricule}/banque")
	public @ResponseBody Collaborateur updateBanqueByMatricule(@PathVariable String matricule,
			@RequestBody Banque banque, HttpServletResponse response) throws IOException {

		// Récupérer le collaborateur par son matricule
		Optional<Collaborateur> collaborateurOpt = cRepo.findByMatricule(matricule);
		Collaborateur newCollaborateur = null;
		if (collaborateurOpt.isPresent()) {
			// TODO validation de la l'objet banque
			collaborateurOpt.get().setBanque(banque);
			newCollaborateur = cRepo.save(collaborateurOpt.get());

			if (null == newCollaborateur) {
				response.sendError(400, "Erreur lors de la mofication de la banque d'un collaboratuer: " + matricule);
			} else {
				response.setHeader("message", "Banque du collaborateur modifié avec succès");
				response.setStatus(200);
			}
		}
		return newCollaborateur;
	}

}
