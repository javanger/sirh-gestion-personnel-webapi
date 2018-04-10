/**
 * 
 */
package com.sirh.personnel.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirh.personnel.webapi.entity.Departement;
import com.sirh.personnel.webapi.repository.DepartementRepository;

/**
 * @author Kevin M.
 *
 */
@RestController
public class DepartementController {

	@Autowired
	DepartementRepository dRepo;

	@RequestMapping("/api/departements")
	public List<Departement> searchAll() {
		return dRepo.findAll();
	}

}
