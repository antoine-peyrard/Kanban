package fr.telecom_st_etienne.fx.kanban.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.telecom_st_etienne.fx.kanban.business.Developpeur;

public interface DeveloppeurDao extends JpaRepository<Developpeur, Long> {

	//Liste des développeurs n'ayant pas encore de tâche
	//List<Developpeur> findByTachesIsEmpty();
}
