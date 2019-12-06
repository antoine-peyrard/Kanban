package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.dao.TypeTacheDao;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;
@Service
public class TypeTacheServiceImpl implements TypeTacheService{

	@Autowired
	private TypeTacheDao typeTacheDao;
	
	@Override
	public TypeTache ajouterTypeTache(int i) {
		TypeTache typeTache = new TypeTache();
		typeTache.setNom(i);
		typeTache.setCouleur(i);
		typeTacheDao.save(typeTache);
		return typeTache;
	}
	
	@Override
	public List<TypeTache> recupererTypeTaches(){
		return typeTacheDao.findAll();
	}
	
	@Override
	public TypeTache recupererTypeTache(Long id) {
		return typeTacheDao.findOne(id);
	}
}
