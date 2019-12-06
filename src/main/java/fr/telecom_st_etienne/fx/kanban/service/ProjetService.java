package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Projet;

public interface ProjetService {

	Projet ajouterProjet(String nom);
	
	List<Projet> recupererProjets();
	
	Projet recupererProjet(Long id);
}
