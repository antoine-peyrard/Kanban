package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;
import fr.telecom_st_etienne.fx.kanban.dao.HistoriqueDeplacementDao;
import fr.telecom_st_etienne.fx.kanban.service.HistoriqueDeplacementService;
@Service
public class HistoriqueServiceImpl implements HistoriqueDeplacementService{

	@Autowired
	private HistoriqueDeplacementDao historiqueDeplacementDao;
	
	@Override
	public HistoriqueDeplacement ajouterHistoriqueDeplacement(Date date) {
		HistoriqueDeplacement historiqueDeplacement = new HistoriqueDeplacement();
		historiqueDeplacement.setDate(date);
		historiqueDeplacementDao.save(historiqueDeplacement);
		return historiqueDeplacement;
	}
	
	public HistoriqueDeplacement recupererHistoriqueDeplacement(Long id) {
		return historiqueDeplacementDao.findOne(id);
	}
	
	public List<HistoriqueDeplacement> recupererHistoriqueDeplacements(){
		return historiqueDeplacementDao.findAll();
	}
	
}
