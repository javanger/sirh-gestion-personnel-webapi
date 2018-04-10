package dev.sgp.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementRepository;

/**
 * @author Emmanuel
 *
 */
@Component
public class StartUpAppListener {
	
	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	CollaborateurRepository collaborateurRepository;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé

		departementRepository.save(new Departement("Informatique"));
		departementRepository.save(new Departement("RH"));
		departementRepository.save(new Departement("Finance"));
		departementRepository.save(new Departement("R&D"));
		
		collaborateurRepository.save(new Collaborateur("Chêne", "Emmanuel", "1995-01-25", "Une adresse", departementRepository.getOne(1), new Banque("BNP", "FR2342412345", "353509876")));
		collaborateurRepository.save(new Collaborateur("Ahsène", "Victor", "1996-06-15", "Une adresse", departementRepository.getOne(2), new Banque("Banque postale", "FR124245345", "0924422876")));
	}
}
