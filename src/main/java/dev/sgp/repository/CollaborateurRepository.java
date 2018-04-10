package dev.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.Collaborateur;

/**
 * @author Emmanuel
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{
	
	List<Collaborateur> findByDepartementId(Integer id);
	
	Collaborateur findByMatricule(String matricule);
	
}
