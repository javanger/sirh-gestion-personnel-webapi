/**
 * 
 */
package dev.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestion.entite.Banque;

/**
 * @author Axel B.
 *
 */
public interface BanqueRepository extends JpaRepository<Banque, Integer> {

}
