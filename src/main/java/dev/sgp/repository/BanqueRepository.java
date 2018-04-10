package dev.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgp.entite.Banque;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {

}
