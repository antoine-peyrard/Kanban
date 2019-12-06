package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.dao.DeveloppeurDao;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;

@Service
public class DeveloppeurServiceImpl implements DeveloppeurService{

	@Autowired
	private DeveloppeurDao developpeurDao;
	
	@Override
	public List<Developpeur> recupererDeveloppeurs(){
		return developpeurDao.findAll();
	}
	
	@Override
	public Developpeur recupererDeveloppeur(Long id) {
		return developpeurDao.findOne(id);
	}
	
	@Override
	public Developpeur ajouterDeveloppeur(String nom, String prenom) {
		Developpeur developpeur = new Developpeur(nom,prenom);
		developpeurDao.save(developpeur);
		return developpeur;
	}
}
