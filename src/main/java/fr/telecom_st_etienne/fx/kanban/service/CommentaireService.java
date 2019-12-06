package fr.telecom_st_etienne.fx.kanban.service;

import java.util.Date;
import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Commentaire;

public interface CommentaireService {

	Commentaire ajouterCommentaire(Date date);
	List <Commentaire> recupererCommentaires();
	Commentaire recupererCommentaire(Long id);
}
