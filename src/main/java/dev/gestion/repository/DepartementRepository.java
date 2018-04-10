/**
 * 
 */
package dev.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestion.entite.Departement;

/**
 * @author Alexis Darcy
 *
 */
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}