package fr.telecom_st_etienne.fx.kanban.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;

@RestController
@RequestMapping("/ws/")
public class KanbanRestController {

	private static final Logger logger = LogManager.getLogger(Logger.class.getName());

	@Autowired
	private TacheService tacheService;
	
	/**
	 * Cette méthode permet d'ajouter une tâche
	 * via le service Web
	 * @return
	 */
	/*@PostMapping("/taches")
	public Tache ajouterTache()
	{
		System.out.println("Demande d'ajout d'une tâche");
		Tache tache = tacheService.ajouterTache("Test20191016");
		return tache;
	}*/
	
	@PostMapping()
	public List<Tache> tachesGet()
	{
		return tacheService.recupererTaches();
	}

	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/taches", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> recupererTaches()
	{
		logger.info("Appel à la méthode recupererTaches()");
	    return tacheService.recupererTaches();
	}

	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/taches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tache recupererTache(@PathVariable Long id)
	{
		logger.info("Appel à la méthode recupererTache()");
	    return tacheService.recupererTache(id);
	}

	/**
	 * Cette méthode permet d'ajouter une nouvelle tache
	 * 
	 * @param intitule de la tache
	 * @return un objet de type Tache
	 */
	/*@PostMapping(value="/taches/{intitule}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tache tachePost(@PathVariable String intitule) {
		Tache tache = tacheService.ajouterTache(intitule);
		return tache;
	}*/
	
	public Tache tachePostAvecParametre(@RequestParam("intitule") String intitule) {
		Tache tache = new Tache();
		tache.setIntitule(intitule);
		return tache;		
	}
	
	// Méthode permettant de supprimer une tâche en précisant son id
	@DeleteMapping(value="/taches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean supprimerTache(@PathVariable Long id)
	{
		Tache tache = tacheService.recupererTache(id);
		if (tache==null) {
			return false;
		}
		tacheService.supprimerTache(tache);
		return true;
	}
	
	// Méthode permettant d’obtenir toutes les tâches dont l’intitulé contient le mot précisé 
	// dans l’URL
	@GetMapping(value = "/tachesFiltrees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> recupererTachesFiltrees(@RequestParam String filtre)
	{
		List<Tache> tachesFiltrees = new ArrayList<>();
	    for (Tache tache : tacheService.recupererTaches()) {
	      if (tache.getIntitule().contains(filtre)) {
	        tachesFiltrees.add(tache);
	      }
	    }
	    return tachesFiltrees;
	}

	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public String handleHttpMediaTypeNotAcceptableException() {
	    return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
	}

}