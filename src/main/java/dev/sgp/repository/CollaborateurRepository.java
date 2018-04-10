package dev.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.sgp.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Collaborateur findByMatricule(String matricule);

	@Query("select c from Collaborateur c join c.departement dp where dp.id = ?1")
	List<Collaborateur> findCollabByDepartement(Integer id);
}
