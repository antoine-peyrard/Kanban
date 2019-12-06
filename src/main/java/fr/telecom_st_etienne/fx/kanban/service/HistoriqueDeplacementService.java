package fr.telecom_st_etienne.fx.kanban.service;

import java.util.Date;
import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;

public interface HistoriqueDeplacementService {

	HistoriqueDeplacement ajouterHistoriqueDeplacement(Date date);
	
	List <HistoriqueDeplacement> recupererHistoriqueDeplacements();
	
	HistoriqueDeplacement recupererHistoriqueDeplacement(Long id);
}
