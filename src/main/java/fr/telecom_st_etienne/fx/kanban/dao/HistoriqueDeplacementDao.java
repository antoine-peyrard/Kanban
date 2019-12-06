package fr.telecom_st_etienne.fx.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.telecom_st_etienne.fx.kanban.business.HistoriqueDeplacement;

public interface HistoriqueDeplacementDao extends JpaRepository<HistoriqueDeplacement, Long> {

}
