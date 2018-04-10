package dev.sgp.listener;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;


@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("departements.xml",
				"collaborateurs.xml", "banques.xml");

		Stream.of(Banque.class, Collaborateur.class, Departement.class, Banque.class)
				.flatMap(classe -> context.getBeansOfType(classe).values().stream()).forEach(em::persist);
	}
}