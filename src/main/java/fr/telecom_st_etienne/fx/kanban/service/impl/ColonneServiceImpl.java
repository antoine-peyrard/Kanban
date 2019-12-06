package fr.telecom_st_etienne.fx.kanban.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.dao.ColonneDao;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
@Service
public class ColonneServiceImpl implements ColonneService{

	@Autowired
	private ColonneDao colonneDao;
	
	@Override
	public Colonne ajouterColonne(String contenu) {
		Colonne colonne = new Colonne();
		colonne.setContenu(contenu);
		colonneDao.save(colonne);
		return colonne;
	}

	@Override
	public List<Colonne> recupererColonnes() {
		return colonneDao.findAll();
	}

	@Override
	public Colonne recupererColonne(Long id) {
		return colonneDao.findOne(id);
	}
}
