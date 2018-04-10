package dev.sirhgestionpersonnelwebapi.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.sirhgestionpersonnelwebapi.entite.Collaborateur;
import dev.sirhgestionpersonnelwebapi.entite.Departement;
import dev.sirhgestionpersonnelwebapi.repository.CollaborateurRepository;
import dev.sirhgestionpersonnelwebapi.repository.DepartementRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private DepartementRepository departementRepo;

	@Autowired
	private CollaborateurRepository collabRepo;

	@Override
	@Transactional
	public void initialiser() {

		if (departementRepo.count() == 0 && collabRepo.count() == 0) {
			Departement dep1 = new Departement("Développement");
			Departement dep2 = new Departement("Administration");

			List<Departement> listDepart = Arrays.asList(dep1, dep2);

			for (Departement dep : listDepart) {
				departementRepo.save(dep);
			}

			List<Collaborateur> listCollab = Arrays.asList(
					new Collaborateur("123456", "Tanon", "Ange", LocalDate.of(1986, 9, 7), "83 route du rhin",
							"102547893", "angetanon@spring.com", "toto.jpeg", ZonedDateTime.now(), true, "developpeur",
							dep1),
					new Collaborateur("458796", "Roland", "Grace", LocalDate.of(1988, 8, 17), "14 route de brechhin",
							"155221", "rolanfqta@spring.com", "totu.jpeg", ZonedDateTime.now(), true, "directeur",
							dep2));

			for (Collaborateur collab : listCollab) {
				collabRepo.save(collab);
			}
		}


		



	}

}
