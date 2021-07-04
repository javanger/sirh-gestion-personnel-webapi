/**
 * 
 */
package com.sirh.personnel.webapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirh.personnel.webapi.entity.Banque;
import com.sirh.personnel.webapi.entity.Collaborateur;
import com.sirh.personnel.webapi.entity.Cordonnees;
import com.sirh.personnel.webapi.entity.Departement;
import com.sirh.personnel.webapi.entity.Identite;
import com.sirh.personnel.webapi.repository.CollaborateurRepository;
import com.sirh.personnel.webapi.repository.DepartementRepository;

/**
 * @author Kevin M.
 *
 */
@Service
public class InflateDataService {

	DepartementRepository dRepo;
	CollaborateurRepository cRepo;

	/**
	 * Constructor
	 * 
	 */
	@Autowired
	public InflateDataService(DepartementRepository dRepo, CollaborateurRepository cRepo) {
		this.dRepo = dRepo;
		this.cRepo = cRepo;
	}

	/**
	 * Insertion des dépatements et collaborateurs : void
	 */
	public void initialiser() {

		List<Departement> departements = new ArrayList<>();
		departements.add(new Departement(0, "Ressources Humaines"));
		departements.add(new Departement(0, "Recherche et Développement"));
		departements.add(new Departement(0, "Comptabilité"));
		departements.add(new Departement(0, "Finance"));

		departements.forEach(d -> dRepo.save(d));

		List<Collaborateur> collaborateurs = new ArrayList<>();

		Identite id1 = new Identite("Possible", "Kim", "photo1.png", LocalDate.now(), "1254785412545215");
		Identite id2 = new Identite("Mensk", "Arthur", "photo2.png", LocalDate.now(), "8795785412545215");
		Identite id3 = new Identite("Kerrigan", "Sara", "photo3.png", LocalDate.now(), "4554785412545445");
		Identite id4 = new Identite("Neutron", "Jimmy", "photo4.png", LocalDate.now(), "9554465468465468");

		Cordonnees c1 = new Cordonnees("0696554875", "Adresse 1");
		Cordonnees c2 = new Cordonnees("0696552135", "Adresse 2");
		Cordonnees c3 = new Cordonnees("0690025545", "Adresse 3");
		Cordonnees c4 = new Cordonnees("0696599878", "Adresse 4");

		Banque b1 = new Banque("La Banque Postale", "145214587", "45SS589E8998EE5456E");
		Banque b2 = new Banque("Société Générale", "4564654654", "DSFG45645F4D8ER4R2");
		Banque b3 = new Banque("Crédit Mutuelle", "7895545554", "C12D54F998EE5456E");
		Banque b4 = new Banque("Caisse d'Epargne", "2541414587", "E78D545F8998EE5456E");

		Departement d1 = dRepo.getOne(1);
		Departement d2 = dRepo.getOne(2);
		Departement d3 = dRepo.getOne(3);

		Collaborateur colab1 = new Collaborateur("M00001", "Espion", true, id1, c1, d1, b1);
		Collaborateur colab2 = new Collaborateur("M00002", "Dictateur", true, id2, c2, d2, b2);
		Collaborateur colab3 = new Collaborateur("M00003", "Assassin", false, id3, c3, d3, b3);
		Collaborateur colab4 = new Collaborateur("M00004", "Genie", true, id4, c4, d3, b4);

		collaborateurs.add(colab1);
		collaborateurs.add(colab2);
		collaborateurs.add(colab3);
		collaborateurs.add(colab4);

		collaborateurs.forEach(c -> cRepo.save(c));
	}

}
