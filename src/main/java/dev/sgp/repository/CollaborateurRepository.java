/**
 * 
 */
package dev.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.sgp.entite.Collaborateur;

/**
 * @author GOBERT Guillaume
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	@Query("SELECT c FROM Collaborateur c JOIN c.departement dp WHERE dp.id = ?1")
	List<Collaborateur> findCollaborateursByDepartement(Integer idDepartement);

	Collaborateur findCollaborateurByMatricule(String matricule);

	Boolean existsByMatricule(String matricule);

}
