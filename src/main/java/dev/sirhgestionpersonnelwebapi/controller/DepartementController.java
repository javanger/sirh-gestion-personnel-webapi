package dev.sirhgestionpersonnelwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sirhgestionpersonnelwebapi.entite.Departement;
import dev.sirhgestionpersonnelwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("/departements")
public class DepartementController {
	@Autowired
	private DepartementRepository departementRepo;

	@GetMapping
	public List<Departement> listerDepartement() {


		return this.departementRepo.findAll();
	}

}
