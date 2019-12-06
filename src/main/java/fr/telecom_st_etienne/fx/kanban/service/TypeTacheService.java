package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.TypeTache;

public interface TypeTacheService {

	TypeTache ajouterTypeTache(int i);
	
	List<TypeTache> recupererTypeTaches();
	
	TypeTache recupererTypeTache(Long id);
}
