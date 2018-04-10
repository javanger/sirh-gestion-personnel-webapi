package dev.sirhgestionpersonnelwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sirhgestionpersonnelwebapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	List<Collaborateur> findByDepartementId(Integer departement);

	Collaborateur findByMatricule(String matricule);


}
