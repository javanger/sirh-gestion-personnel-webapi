package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Collaborateurs;

public interface CollaborateursRepository extends JpaRepository<Collaborateurs, Integer> {

	List<Collaborateurs> findByDepartementId(int Id);

	Collaborateurs findByMatricule(String matricule);

}
