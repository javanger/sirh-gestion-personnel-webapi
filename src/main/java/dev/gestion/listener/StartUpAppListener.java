/**
 * 
 */
package dev.gestion.listener;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.gestion.entite.Banque;
import dev.gestion.entite.Collaborateur;
import dev.gestion.entite.Departement;

/**
 * @author Alexis Darcy
 *
 */
@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void contextRefreshedEvent() {
		List<Departement> listeDepartement = new ArrayList<>();

		listeDepartement.add(new Departement("Comptabilite"));
		listeDepartement.add(new Departement("Ressources Humaines"));
		listeDepartement.add(new Departement("Informatique"));
		listeDepartement.add(new Departement("Administratif"));

		listeDepartement.forEach(em::persist);

		List<Banque> listeBanque = new ArrayList<>();

		listeBanque.add(new Banque("Caisse d'épargne", "1521512ED211", "158555585461256213222532"));
		listeBanque.add(new Banque("LCL", "15154412ED211", "15855558145451213222532"));
		listeBanque.add(new Banque("CIC", "152444142ED211", "158555585461441412553222532"));

		listeBanque.forEach(em::persist);

		List<Collaborateur> listCollaborateur = new ArrayList<>();

		listCollaborateur.add(new Collaborateur("M01", "Durant", "Jean", listeBanque.get(0), listeDepartement.get(0)));
		listCollaborateur.add(new Collaborateur("M02", "Dupont", "Jean", listeBanque.get(1), listeDepartement.get(1)));
		listCollaborateur.add(new Collaborateur("M03", "Doe", "John", listeBanque.get(2), listeDepartement.get(2)));

		listCollaborateur.forEach(em::persist);
	}
}
