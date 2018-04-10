package dev.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.Departement;

/**
 * @author Emmanuel
 *
 */
public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	
}