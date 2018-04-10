/**
 * 
 */
package dev.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.Collaborateur;

/**
 * @author Emmanuel
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{
	
}
