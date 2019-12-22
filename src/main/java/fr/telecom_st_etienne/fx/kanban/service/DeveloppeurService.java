package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
public interface DeveloppeurService {

	Developpeur ajouterDeveloppeur(String nom,String prenom);
	List<Developpeur> recupererDeveloppeurs();
	Developpeur recupererDeveloppeur(Long id);
	List<Developpeur> recupererDeveloppeurList(List<Long> ids);

}
