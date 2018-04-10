package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Departements;
import dev.repository.DepartementRepository;

@RestController
@RequestMapping("api/departements")
public class ApiDepartementsController {

	@Autowired
	private DepartementRepository departementRepo;

	@GetMapping
	public List<Departements> listerdepartements() {
		return this.departementRepo.findAll();
	}

}