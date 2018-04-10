package dev.sirhgestionpersonnelwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sirhgestionpersonnelwebapi.entite.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
