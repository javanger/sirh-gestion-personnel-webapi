package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Departements;
import dev.sgp.repository.DepartementsRepository;

@RestController
@RequestMapping("/departements")
public class DepartementController {

	@Autowired
	private DepartementsRepository departementRepo;

	@GetMapping
	public List<Departements> listerexemples() {
		return this.departementRepo.findAll();
	}

}
