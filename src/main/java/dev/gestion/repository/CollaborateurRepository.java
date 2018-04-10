/**
 * 
 */
package dev.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.gestion.entite.Collaborateur;

/**
 * @author Axel B.
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Collaborateur findByMatricule(String matricule);

	@Query("select c from Collaborateur c join c.departement dp where dp.id = ?1")

	List<Collaborateur> findByDepartement(Integer id);

	Boolean existsByMatricule(String matricule);

}
