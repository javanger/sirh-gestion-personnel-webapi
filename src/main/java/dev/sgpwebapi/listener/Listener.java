package dev.sgpwebapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgpwebapi.entite.Departement;
import dev.sgpwebapi.repository.DepartementRepository;

@Component
public class Listener {

	@Autowired
	DepartementRepository departementRepositiry;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé


		departementRepositiry.save(new Departement("informatique"));
		departementRepositiry.save(new Departement("comptabilité"));
		departementRepositiry.save(new Departement("rh"));

	}

}
