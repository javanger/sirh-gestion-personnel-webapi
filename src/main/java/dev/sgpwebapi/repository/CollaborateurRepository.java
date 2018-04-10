package dev.sgpwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpwebapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	List<Collaborateur> findByDepartementId(int id);

	Collaborateur findByMatricule(String matricule);

}
