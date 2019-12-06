package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Projet;
import fr.telecom_st_etienne.fx.kanban.dao.ProjetDao;
import fr.telecom_st_etienne.fx.kanban.service.ProjetService;
@Service
public class ProjetServiceImpl implements ProjetService{

	@Autowired
	private ProjetDao projetDao;
	
	@Override
	public Projet ajouterProjet(String nom) {
		Projet projet = new Projet();
		projet.setNom(nom);
		projetDao.save(projet);
		return projet;
	}
	
	@Override
	public Projet recupererProjet(Long id) {
		return projetDao.findOne(id);
	}
	
	@Override
	public List<Projet> recupererProjets(){
		return projetDao.findAll();
	}
}
