/**
 * 
 */
package dev.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestion.entite.Banque;

/**
 * @author Alexis Darcy
 *
 */
public interface BanqueRepository extends JpaRepository<Banque, Integer> {
}