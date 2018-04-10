/**
 * 
 */
package com.sirh.personnel.webapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sirh.personnel.webapi.service.InflateDataService;


/**
 * @author Kevin M.
 *
 */
@Component
public class StartUpAppListener {

	@Autowired
	private InflateDataService inflateDataService;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé
		inflateDataService.initialiser();
	}

}
