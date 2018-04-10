/**
 * 
 */
package com.sirh.personnel.webapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirh.personnel.webapi.entity.Collaborateur;
import com.sirh.personnel.webapi.entity.Departement;

/**
 * @author Kevin M.
 *
 */
public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	Optional<Collaborateur> findByMatricule(String matricule);

	List<Collaborateur> findByDepartement(Departement departement);
}
