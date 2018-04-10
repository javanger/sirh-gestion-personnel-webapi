/**
 * 
 */
package dev.gestion.web.listener;

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
 * @author Axel B.
 *
 */
@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void contextRefreshedEvent() {

		List<Departement> d = new ArrayList<Departement>();

		d.add(new Departement("Informatique"));
		d.add(new Departement("Administration"));
		d.add(new Departement("Video"));

		d.forEach(em::persist);

		List<Banque> b = new ArrayList<Banque>();
		b.add(new Banque("CIC", "123456789", "123"));
		b.add(new Banque("MATMUT", "987654321", "456"));
		b.add(new Banque("Crédit agricole", "159874632", "789"));

		b.forEach(em::persist);

		List<Collaborateur> c = new ArrayList<Collaborateur>();

		c.add(new Collaborateur("D03", "Jean", "oui", d.get(0), b.get(0)));
		c.add(new Collaborateur("D04", "chene", "Emmanuel", d.get(1), b.get(1)));
		c.add(new Collaborateur("D06", "kevin", "martinel", d.get(2), b.get(2)));

		c.forEach(em::persist);

	}
}
