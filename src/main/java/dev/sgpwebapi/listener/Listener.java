package dev.sgpwebapi.listener;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.entite.Departement;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;

@Component
public class Listener {

	@Autowired
	DepartementRepository departementRepositiry;

	@Autowired
	CollaborateurRepository collabRepository;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé


		departementRepositiry.save(new Departement("informatique"));
		departementRepositiry.save(new Departement("comptabilité"));
		departementRepositiry.save(new Departement("rh"));
		
		collabRepository.save(new Collaborateur("100010101", "dupont", "jacques", LocalDate.of(1994, 03, 03),
				"15 rue du four", "devjava", departementRepositiry.getOne(1)));
		collabRepository.save(new Collaborateur("020202021", "prevot", "pierre", LocalDate.of(1987, 03, 03),
				"15 rue des pres", "assistant", departementRepositiry.getOne(2)));
		collabRepository.save(new Collaborateur("05320140", "Osman", "fleure", LocalDate.of(1963, 03, 03),
				"15 rue des lilas", "assistante", departementRepositiry.getOne(3)));

	}

}
