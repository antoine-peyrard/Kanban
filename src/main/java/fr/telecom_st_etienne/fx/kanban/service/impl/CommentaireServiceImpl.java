package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Commentaire;
import fr.telecom_st_etienne.fx.kanban.dao.CommentaireDao;
import fr.telecom_st_etienne.fx.kanban.service.CommentaireService;
@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDao commentaireDao;
	
	@Override
	public Commentaire ajouterCommentaire(Date date) {
		Commentaire commentaire = new Commentaire();
		commentaire.setDate(date);
		commentaireDao.save(commentaire);
		return commentaire;
	}
	
	@Override
	public List<Commentaire> recupererCommentaires(){
		return commentaireDao.findAll();
	}
	
	@Override
	public Commentaire recupererCommentaire(Long id) {
		return commentaireDao.findOne(id);
	}
}
