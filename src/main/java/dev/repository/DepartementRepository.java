package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Departements;

public interface DepartementRepository extends JpaRepository<Departements, Integer> {

}