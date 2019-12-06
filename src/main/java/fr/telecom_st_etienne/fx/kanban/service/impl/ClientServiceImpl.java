package fr.telecom_st_etienne.fx.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.telecom_st_etienne.fx.kanban.business.Client;
import fr.telecom_st_etienne.fx.kanban.dao.ClientDao;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client ajouterClient(String nom) {
		Client client = new Client();
		client.setNom(nom);
		clientDao.save(client);
		return client;
	}

	@Override
	public List<Client> recupererClients() {
		return clientDao.findAll();
	}

	@Override
	public Client recupererClient(Long id) {
		return clientDao.findOne(id);
	}
}
