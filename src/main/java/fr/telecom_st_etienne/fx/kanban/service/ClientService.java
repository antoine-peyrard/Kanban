package fr.telecom_st_etienne.fx.kanban.service;

import java.util.List;

import fr.telecom_st_etienne.fx.kanban.business.Client;

public interface ClientService {

	Client ajouterClient(String intitule);
	
	List<Client> recupererClients();

	Client recupererClient(Long id);
}
