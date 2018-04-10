package dev.sgpwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collarepo;

	@GetMapping
	public List<Collaborateur> listerCollaborateur() {
		return this.collarepo.findAll();
	}

}
