/**
 * 
 */
package com.sirh.personnel.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirh.personnel.webapi.entity.Departement;

/**
 * @author Kevin M.
 *
 */
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
