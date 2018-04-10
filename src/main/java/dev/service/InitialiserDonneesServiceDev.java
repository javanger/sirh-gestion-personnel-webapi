package dev.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Banque;
import dev.entite.Collaborateurs;
import dev.entite.Departements;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void initialiser() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextConfig.xml");

		Map<String, Departements> departements = context.getBeansOfType(Departements.class);

		departements.forEach((x, y) -> {
			em.persist(y);
		});

		Map<String, Collaborateurs> collaborateurs = context.getBeansOfType(Collaborateurs.class);

		collaborateurs.forEach((x, y) -> {
			em.persist(y);
		});

		Map<String, Banque> banque = context.getBeansOfType(Banque.class);

		banque.forEach((x, y) -> {
			em.persist(y);
		});

	}

}