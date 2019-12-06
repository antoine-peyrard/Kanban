package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;

public interface TacheService {

	Tache ajouterTache(Tache tache);
	
	List<Tache> recupererTaches();

	Tache recupererTache(Long id);

	void supprimerTache(Tache tache);

	Page<Tache> recupererTaches(Pageable pageable);

	Tache ajouterTache(String intitule, TypeTache typeTache, Colonne colonne);

	void enregistrerTache(Tache tache);
	
	void deplacerTache(int direction,Long id);
}
