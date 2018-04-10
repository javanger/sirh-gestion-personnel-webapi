package dev.sgp.service;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departements;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configWeb.xml");
		
		Stream.of(Departements.class, Banque.class, Collaborateur.class)
		.flatMap(classe -> context.getBeansOfType(classe).values().stream())
		.forEach(em::persist);
		context.close();
		
	}

}
