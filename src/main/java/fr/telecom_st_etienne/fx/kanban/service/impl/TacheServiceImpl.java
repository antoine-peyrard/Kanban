package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Developpeur;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.dao.ColonneDao;
import fr.telecom_st_etienne.fx.kanban.dao.TacheDao;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;

@Service
public class TacheServiceImpl implements TacheService {

	@Autowired
	private TacheDao tacheDAO;
	
	@Autowired
	private ColonneDao colonneDAO;

	@Override
	public Tache ajouterTache(String intitule,TypeTache typeTache, Colonne colonne,List<Developpeur> developpeurs) {
		Tache tache = new Tache(intitule,typeTache,colonne);
		tache.setDeveloppeurs(developpeurs);
		tache = tacheDAO.save(tache);
		return tache;
	}
	
	@Override
	public Tache ajouterTache(Tache tache) {
		tache = tacheDAO.save(tache);
		return tache;
	}

	@Override
	public List<Tache> recupererTaches() {
		return tacheDAO.findAll();
	}

	@Override
	public Tache recupererTache(Long id) {
		return tacheDAO.findOne(id);
	}

	@Override
	public void supprimerTache(Tache tache) {
		tacheDAO.delete(tache);
	}

	@Override
	public Page<Tache> recupererTaches(Pageable pageable) {
		// TODO Auto-generated method stub
		return tacheDAO.findAll(pageable);
	}

	public void deplacerTache(int direction,Long id) {
		List<Colonne> colonnes = colonneDAO.findAll();
		Tache tache = tacheDAO.findOne(id);
		for(int i=0;i<colonnes.size();i++) {
			if(tache.getColonne().getContenu().equals(colonnes.get(i).getContenu())) {
				if(direction==1 && i<colonnes.size()-1) {
					tache.setColonneName(colonnes.get(i+1).getContenu());
					break;
				}else if(direction ==-1 && i>0) {
					tache.setColonneName(colonnes.get(i-1).getContenu());
					break;
				}
			}
		}		
		enregistrerTache(tache);
	}
	@Override
	public void enregistrerTache(Tache tache) {
		tacheDAO.save(tache);
	}

}
