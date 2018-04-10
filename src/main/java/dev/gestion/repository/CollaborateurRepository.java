/**
 * 
 */
package dev.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestion.entite.Collaborateur;

/**
 * @author Alexis Darcy
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	List<Collaborateur> findByDepartementId(Integer id);

	Collaborateur findByMatricule(String matricule);
}